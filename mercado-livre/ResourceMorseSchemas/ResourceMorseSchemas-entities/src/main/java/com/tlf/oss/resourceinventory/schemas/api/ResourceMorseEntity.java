package com.tlf.oss.resourceinventory.schemas.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.mercadolivre.morseresource.MorseBits;
import com.mercadolivre.morseresource.MorseHuman;
import com.mercadolivre.morseresource.Result;

/**
 * Entidade que será trafegada entre todas as camadas do Apps
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceMorseEntity", propOrder = { "morseBits", "morseHuman", "result"})
public class ResourceMorseEntity {

	private MorseBits morseBits;
	private MorseHuman morseHuman;
	private Result result;

	public MorseBits getMorseBits() {
		return morseBits;
	}

	public void setMorseBits(MorseBits morseBits) {
		this.morseBits = morseBits;
	}

	public MorseHuman getMorseHuman() {
		return morseHuman;
	}

	public void setMorseHuman(MorseHuman morseHuman) {
		this.morseHuman = morseHuman;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

}
