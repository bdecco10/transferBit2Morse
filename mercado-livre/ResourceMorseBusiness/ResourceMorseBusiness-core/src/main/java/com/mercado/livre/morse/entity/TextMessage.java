package com.mercado.livre.morse.entity;
import java.util.List;

public class TextMessage {

	 private List<String> parsedMessage;

		public TextMessage(List<String> parse) {
		}
		
		public TextMessage() {	}
		
	public List<String> getParsedMessage() {
		return parsedMessage;
	}

	public void setParsedMessage(List<String> parsedMessage) {
		this.parsedMessage = parsedMessage;
	}
	 
	 
}