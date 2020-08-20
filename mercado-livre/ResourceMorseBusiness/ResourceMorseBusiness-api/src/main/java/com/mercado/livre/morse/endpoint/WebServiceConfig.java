package com.mercado.livre.morse.endpoint;

import java.util.Properties;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.mercado.livre.morse.core.CallService;
import com.mercado.livre.morse.core.ResourceMorse;
import com.tlf.oss.common.header.Header;
import com.tlf.oss.common.log.OSSLogger;

@EnableWs
@Configuration
@PropertySource("classpath:app.properties")
public class WebServiceConfig extends WsConfigurerAdapter{

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/ws/*");
	}

	@Bean(name = "morse")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();

		wsdl11Definition.setPortTypeName("MorsePort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://mercadolivre.com/morseResource");

		wsdl11Definition.setSchema(countriesSchema);

		return wsdl11Definition;
	}

	@Bean
	public SimpleMappingExceptionResolver simpleExceptionResolver(){
		SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
		Properties exceptions = new Properties();
		exceptions.put(ArithmeticException.class, "error");
		resolver.setExceptionMappings(exceptions);
		return resolver;
	}

	@Bean
	public XsdSchema countriesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("/Schema/Morse.xsd"));
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer swaggerProperties() {
		PropertySourcesPlaceholderConfigurer p = new PropertySourcesPlaceholderConfigurer();
		p.setIgnoreUnresolvablePlaceholders(true);
		return p;
	}

	@Bean
	public ResourceMorse ri() {
		return new ResourceMorse();
	}

	@Bean
	public CallService call() {
		return new CallService();
	}

	@Bean
	public OSSLogger logger() {
		return new OSSLogger();
	}

	@Bean
	public Header header() {
		return new Header();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
