package com.mercado.livre.morse.core.util;

import com.mercadolivre.morseresource.MorseBitsRequest;
import com.mercadolivre.morseresource.MorseBitsResponse;
import com.mercadolivre.morseresource.MorseTranslateRequest;
import com.mercadolivre.morseresource.MorseTranslateResponse;
import com.tlf.oss.resourceinventory.schemas.api.ResourceMorseEntity;

public class EntityConverter {

	public static ResourceMorseEntity toResourceInventoryEntity(MorseBitsRequest in) {
		ResourceMorseEntity ri = new ResourceMorseEntity();
		ri.setMorseBits(in.getMorseBits());
		return ri;
	}

	public static MorseBitsResponse toDetermineResourceAvailabilityOut(ResourceMorseEntity res) {
		MorseBitsResponse out = new MorseBitsResponse();
		out.setMorseResult(res.getResult());
		return out;
	}

	public static ResourceMorseEntity toResourceInventoryEntity(MorseTranslateRequest in) {
		ResourceMorseEntity ri = new ResourceMorseEntity();
		ri.setMorseHuman(in.getMorseTranslate());
		return ri;
	}

	public static MorseTranslateResponse toReserveResourceOut(ResourceMorseEntity res) {
		MorseTranslateResponse out = new MorseTranslateResponse();
		out.setMorseResult(res.getResult());
		return out;
	}

}
