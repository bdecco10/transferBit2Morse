package com.mercado.livre.morse.core;

import javax.inject.Inject;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.mercado.livre.morse.entity.TranslationRequest;
import com.mercado.livre.morse.entity.TranslationResponse;
import com.mercado.livre.morse.service.TranslateService;
import com.mercadolivre.morseresource.Result;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.common.xml.XMLUtil;
import com.tlf.oss.resourceinventory.schemas.api.ResourceMorseEntity;
@Logged
@Component
public class CallService {

	@Inject
	private OSSLogger logger;

	@Inject
	private RestTemplate restTemplate;

	@Value("${resource.url}")
	private String orchResourceUrl ;

	@Value("${resource.port}")
	private String orchResourcePort ;

	@Inject
	private TranslateService translationService;

	/**
	 * HYSTRIX
	 * commandProperties: 
	 * 	{ timeoutInMilliseconds = tempo de espera da solicitação webservice, caso passar da fallback
	 * 	  requestVolumeThreshold = limita a quatidades de erro que o hystrix desarma, no caso o 3 erro
	 * 	  ele para e nem faz mais a solicitação ao serviço e o metodo retorna null
	 * 	  sleepWindowInMilliseconds = define o intervalo de tempo no qual a proxima solicitação vai ser feita
	 * 	}
	 *    threadPoolProperties:
	 * 	    coreSize = quantidades de threads ativa executando o processo
	 * 	}
	 */
	@HystrixCommand(fallbackMethod = "fallbackDefault",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "60000"),
			@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "180000") }, threadPoolProperties = {
					@HystrixProperty(name = "coreSize", value = "30"),
					@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "180000") })
	public ResponseEntity<?> callServiceRest(String operation, ResourceMorseEntity in) throws OSSBusinessException {
		ResponseEntity<?> response = null ;

		try{

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			ClientHttpRequestFactory requestFactory = getClientHttpRequestFactory();
			restTemplate.setRequestFactory(requestFactory);

			logger.log(OSSLogger.INFO, "Chamando a url " + orchResourceUrl+":"+orchResourcePort+"/"+operation);
			logger.log(OSSLogger.INFO, "ResourceInventoryEntity -> " + XMLUtil.getXMLValue(in));

			HttpEntity<ResourceMorseEntity> request = new HttpEntity<>(in,headers);
			response =  restTemplate.exchange("http://"+orchResourceUrl+":"+orchResourcePort+"/"+operation+"/", HttpMethod.POST, request, ResourceMorseEntity.class);

		}catch (HttpServerErrorException e) {
			throw new OSSBusinessException(e.getStatusCode().name(),String.valueOf(e.getRawStatusCode()), e.getResponseBodyAsString());
		}catch (HttpClientErrorException e) {
			throw new OSSBusinessException(e.getStatusCode().name(),String.valueOf(e.getRawStatusCode()) , e.getResponseBodyAsString());
		}catch (Exception e) {
			throw new OSSBusinessException(HttpStatus.BAD_REQUEST.name(),"MORSE-001" , e.getMessage());
		}
		return response;
	}
	
	
	public ResourceMorseEntity decodeBits2MorseRest(String operation, ResourceMorseEntity in) throws OSSBusinessException {
		ResourceMorseEntity response = new ResourceMorseEntity();
		try{
			 TranslationRequest messageRequest = new TranslationRequest();
			 messageRequest.setText(in.getMorseBits().getDecodeBits2Morse());
			 TranslationResponse resp = decodeBits2Morse(messageRequest);
			 response.setResult(new Result());
			 response.getResult().setDescription(resp.getResponse());
			 response.getResult().setCode(String.valueOf(resp.getCode()));
			 
		}catch (HttpServerErrorException e) {
			throw new OSSBusinessException(e.getStatusCode().name(),String.valueOf(e.getRawStatusCode()), e.getResponseBodyAsString());
		}catch (HttpClientErrorException e) {
			throw new OSSBusinessException(e.getStatusCode().name(),String.valueOf(e.getRawStatusCode()) , e.getResponseBodyAsString());
		}catch (Exception e) {
			throw new OSSBusinessException(HttpStatus.BAD_REQUEST.name(),"MORSE-001" , e.getMessage());
		}
		return response;
	}

	public ResourceMorseEntity morseTranslate(String operation, ResourceMorseEntity in) throws OSSBusinessException {
		ResourceMorseEntity response = new ResourceMorseEntity();
		try{
			 TranslationRequest messageRequest = new TranslationRequest();
			 messageRequest.setText(in.getMorseHuman().getTranslate2Human());
			 TranslationResponse resp = morseTranslate(messageRequest);
			 response.setResult(new Result());
			 response.getResult().setDescription(resp.getResponse());
			 response.getResult().setCode(String.valueOf(resp.getCode()));
			 
		}catch (HttpServerErrorException e) {
			throw new OSSBusinessException(e.getStatusCode().name(),String.valueOf(e.getRawStatusCode()), e.getResponseBodyAsString());
		}catch (HttpClientErrorException e) {
			throw new OSSBusinessException(e.getStatusCode().name(),String.valueOf(e.getRawStatusCode()) , e.getResponseBodyAsString());
		}catch (Exception e) {
			throw new OSSBusinessException(HttpStatus.BAD_REQUEST.name(),"MORSE-001" , e.getMessage());
		}
		return response;
	}



	public TranslationResponse decodeBits2Morse(TranslationRequest messageRequest) {
		return translationService.decodeBits2Morse(messageRequest);
	}

	public TranslationResponse morseTranslate(TranslationRequest messageRequest) {
		return translationService.translateToText(messageRequest);
	}
	
	public ResponseEntity<?> fallbackDefault(String operation, ResourceMorseEntity resourceMorseEntity) {
		ResourceMorseEntity morseFallback = new ResourceMorseEntity();
		morseFallback.setResult(new Result());
		morseFallback.getResult().setDescription("Timeout histrix:");
		morseFallback.getResult().setCode("MORSE-001");

		return ResponseEntity.ok(morseFallback);
	}

	private ClientHttpRequestFactory getClientHttpRequestFactory() {
		int timeout = 50000;
		RequestConfig config = RequestConfig.custom()
				.setConnectTimeout(timeout)
				.setConnectionRequestTimeout(timeout)
				.setSocketTimeout(timeout)
				.build();
		CloseableHttpClient client = HttpClientBuilder
				.create()
				.setDefaultRequestConfig(config)
				.build();
		return new HttpComponentsClientHttpRequestFactory(client);
	}
}