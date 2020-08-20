package com.mercado.livre.morse.entity;
import java.util.List;

public class MorseMessage {

	 private List<String> parsedMessage;

	public MorseMessage(List<String> parse) {
		parsedMessage=parse;
	}
	
	public MorseMessage() {	}
	
	public List<String> getParsedMessage() {
		return parsedMessage;
	}

	public void setParsedMessage(List<String> parsedMessage) {
		this.parsedMessage = parsedMessage;
	}
	 
}