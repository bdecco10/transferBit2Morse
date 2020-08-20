package com.mercado.livre.morse.api;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mercado.livre.morse.core.ResourceMorse;
import com.mercado.livre.morse.core.util.Validator;
import com.mercadolivre.morseresource.MorseBitsRequest;
import com.mercadolivre.morseresource.MorseBitsResponse;
import com.mercadolivre.morseresource.MorseTranslateRequest;
import com.mercadolivre.morseresource.MorseTranslateResponse;
import com.tlf.oss.common.exception.OSSBusinessException;

@Endpoint
public class MorseResource extends Validator{

	/**
	 * Classe responsavel por expor o serviço SOAP 
	 * A interface de comunicação é externalizada, caso precise de alguma alteração é necessario
	 * alterar o projeto "ResourceMorseSchema" 
	 * Existe dois payload "MorseBitsRequest" e "MorseTranslateRequest"
	 * Cada um responsavel por uma solicitação diferente, a interface MorseBitsRequest consome o serviço que
	 * transforma a mensagem de bit para codigo morsa
	 * A interface MorseTranslateRequest transforma de codigo morsa para texto
	 * OBS: Essa API tem como objetivo estar externalizada para qualuqer camada de integração poder consumir
	 * seguindo um padrao SOAP
	 */
	
	@Inject
	private ResourceMorse ri;

	@PayloadRoot(localPart = "MorseBitsRequest", namespace = "http://mercadolivre.com/morseResource")
	@ResponsePayload
	public MorseBitsResponse decodeBits2Morse(@Valid @RequestPayload MorseBitsRequest entity) throws OSSBusinessException {

		isEmptyBits2Morse(entity);
		return	ri.decodeBits2Morse(entity);

	}
	
	@PayloadRoot(localPart = "MorseTranslateRequest", namespace = "http://mercadolivre.com/morseResource")
	@ResponsePayload
	public MorseTranslateResponse translate2Morse(@Valid @RequestPayload MorseTranslateRequest entity) throws OSSBusinessException {

		isEmptyTrasnlate2Morse(entity);
		return	ri.translate2Morse(entity);

	}

}
