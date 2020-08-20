package com.mercado.livre.morse.api;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercado.livre.morse.core.ResourceMorse;
import com.mercado.livre.morse.core.util.Validator;
import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.schemas.api.ResourceMorseEntity;

@RestController
@RequestMapping(value = "/morseTranslate")
public class MorseResourceRest extends Validator{
	/**
	 * Classe responsavel por expor o serviço rest
	 * A interface de comunicação é externalizada,por tanto qualquer apps que precisar consumir
	 * o serviço é necessário importar a entity "ResourceMorseEntity"
	 * OBS: O ideal seria essa classe confome a regra de negocio toda, estar em outro projeto
	 * para poder ser um apps sem acoplação e de facil escalabilidade
	 * mas como não tive tempo desenvolvi na mesma API que disponibiliza o serviço SOAP
	 */
	@Inject
	private ResourceMorse ri;

    @PostMapping(path = "/bits2morse")
    public ResourceMorseEntity decodeBits2Morse(@Valid @RequestBody ResourceMorseEntity translationRequest)throws OSSBusinessException {
    	isEmptyBits2Morse(translationRequest);
    	return ri.decodeBits2MorseRest(translationRequest);
    }

    @PostMapping(path = "/translate2morse")
    public ResourceMorseEntity morseTranslate(@Valid @RequestBody ResourceMorseEntity translationRequest)throws OSSBusinessException {
    	isEmptyTrasnlate2Morse(translationRequest);
    	return ri.morseTranslate(translationRequest);
    }


}
