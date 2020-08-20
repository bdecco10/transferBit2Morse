package com.mercado.livre.morse.core.util;

import org.springframework.http.HttpStatus;

import com.mercadolivre.morseresource.MorseBitsRequest;
import com.mercadolivre.morseresource.MorseTranslateRequest;
import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.schemas.api.ResourceMorseEntity;

public abstract class Validator {

	public void isEmptyBits2Morse(MorseBitsRequest entity) throws OSSBusinessException{
		if(null==entity.getMorseBits()||null==entity.getMorseBits().getDecodeBits2Morse()
				||entity.getMorseBits().getDecodeBits2Morse().isEmpty()){
			throw new OSSBusinessException(HttpStatus.NOT_FOUND.name(),"MORSE-001" , "Campo getDecodeBits2Morse null");
		}else if(!entity.getMorseBits().getDecodeBits2Morse().replaceAll("\\s+","").matches("^[0-9]{1,}$")){
			throw new OSSBusinessException(HttpStatus.NOT_ACCEPTABLE.name(),"MORSE-002" , "Campo getDecodeBits2Morse obrigatorio preencher em bit 0 e 1");
		}
	}
	public void isEmptyTrasnlate2Morse(MorseTranslateRequest entity) throws OSSBusinessException{
		if(null==entity.getMorseTranslate()||null==entity.getMorseTranslate().getTranslate2Human()
				||entity.getMorseTranslate().getTranslate2Human().isEmpty()){
			throw new OSSBusinessException(HttpStatus.NOT_FOUND.name(),"MORSE-001" , "Campo getTranslate2Human null");
		}else if(!entity.getMorseTranslate().getTranslate2Human().replaceAll("\\s+","").matches("^\\.[.-]+[^\\d$]+[^A-z$]")){
			throw new OSSBusinessException(HttpStatus.NOT_ACCEPTABLE.name(),"MORSE-002" , "Campo getDecodeBits2Morse obrigatorio preencher em bit 0 e 1");
		}
	}

	public void isEmptyBits2Morse(ResourceMorseEntity entity) throws OSSBusinessException{
		if(null==entity.getMorseBits()||null==entity.getMorseBits().getDecodeBits2Morse()
				||entity.getMorseBits().getDecodeBits2Morse().isEmpty()){
			throw new OSSBusinessException(HttpStatus.NOT_FOUND.name(),"MORSE-001" , "Campo getDecodeBits2Morse null");
		}else if(!entity.getMorseBits().getDecodeBits2Morse().replaceAll("\\s+","").matches("^[0-9]{1,}$")){
			throw new OSSBusinessException(HttpStatus.NOT_ACCEPTABLE.name(),"MORSE-002" , "Campo getDecodeBits2Morse obrigatorio preencher em bit 0 e 1");
		}
	}
	public void isEmptyTrasnlate2Morse(ResourceMorseEntity entity) throws OSSBusinessException{
		if(null==entity.getMorseHuman()||null==entity.getMorseHuman().getTranslate2Human()
				||entity.getMorseHuman().getTranslate2Human().isEmpty()){
			throw new OSSBusinessException(HttpStatus.NOT_FOUND.name(),"MORSE-001" , "Campo getTranslate2Human null");
		}else if(!entity.getMorseHuman().getTranslate2Human().replaceAll("\\s+","").matches("^\\.[.-]+[^\\d$]+[^A-z$]")){
			throw new OSSBusinessException(HttpStatus.NOT_ACCEPTABLE.name(),"MORSE-002" , "Campo getDecodeBits2Morse obrigatorio preencher em bit 0 e 1");
		}
	}

}
