package com.mercado.livre.morse.core;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;

import com.mercado.livre.morse.core.util.Constants;
import com.mercado.livre.morse.core.util.EntityConverter;
import com.mercadolivre.morseresource.MorseBitsRequest;
import com.mercadolivre.morseresource.MorseBitsResponse;
import com.mercadolivre.morseresource.MorseTranslateRequest;
import com.mercadolivre.morseresource.MorseTranslateResponse;
import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.resourceinventory.schemas.api.ResourceMorseEntity;

@Logged
public class ResourceMorse {

	@Inject
	private CallService callService;

	private ResourceMorseEntity getEntity(ResponseEntity entityResponse){
		
		ResourceMorseEntity reuslt = (ResourceMorseEntity) entityResponse.getBody();
		return reuslt;
		
	}
	
	public MorseBitsResponse decodeBits2Morse(MorseBitsRequest entity) throws OSSBusinessException {

		ResourceMorseEntity resourceInventoryEntity = EntityConverter.toResourceInventoryEntity(entity);

		ResponseEntity<?> res = callService.callServiceRest(Constants.OPER_BITS2MORSE, resourceInventoryEntity);
		
		return EntityConverter.toDetermineResourceAvailabilityOut(getEntity(res));
		
	}

	public MorseTranslateResponse translate2Morse(MorseTranslateRequest in) throws OSSBusinessException {
		ResourceMorseEntity resourceInventoryEntity = EntityConverter.toResourceInventoryEntity(in);

		ResponseEntity<?> res = callService.callServiceRest(Constants.OPER_TRANSLATE2MORSE, resourceInventoryEntity);
		return EntityConverter.toReserveResourceOut(getEntity(res));
	}

	public ResourceMorseEntity decodeBits2MorseRest(ResourceMorseEntity entity) throws OSSBusinessException {

		ResourceMorseEntity res = callService.decodeBits2MorseRest(Constants.OPER_BITS2MORSE, entity);
		return res;
		
	}

	public ResourceMorseEntity morseTranslate(ResourceMorseEntity entity) throws OSSBusinessException {

		ResourceMorseEntity res = callService.morseTranslate(Constants.OPER_TRANSLATE2MORSE, entity);
		return res;
		
	}

}
