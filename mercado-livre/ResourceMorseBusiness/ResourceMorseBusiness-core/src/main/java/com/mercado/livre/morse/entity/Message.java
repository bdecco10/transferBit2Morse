package com.mercado.livre.morse.entity;
import java.util.HashMap;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Message {

    private String receivedMessage;

    private BinaryMessage binaryMessage;

    private TextMessage textMessage;

    private MorseMessage morseMessage;

    public static final HashMap<String, String> TRANSLATION_TABLE = new HashMap<String, String>() {{
        put("A", ".-");
        put("B", "-...");
        put("C", "-.-.");
        put("D", "-..");
        put("E", ".");
        put("F", "..-.");
        put("G", "--.");
        put("H", "....");
        put("I", "..");
        put("J", ".---");
        put("K", "-.-");
        put("L", ".-..");
        put("M", "--");
        put("N", "-.");
        put("O", "---");
        put("P", ".--.");
        put("Q", "--.-");
        put("R", ".-.");
        put("S", "...");
        put("T", "-");
        put("U", "..-");
        put("V", "...-");
        put("W", ".--");
        put("X", "-..-");
        put("Y", "-.--");
        put("Z", "--..");
        put("0", "-----");
        put("1", ".----");
        put("2", "..---");
        put("3", "...--");
        put("4", "....-");
        put("5", ".....");
        put("6", "-....");
        put("7", "--...");
        put("8", "---..");
        put("9", "----.");
        put(".", ".-.-.-");
        put(" ", " ");
    }};

	public String getReceivedMessage() {
		return receivedMessage;
	}

	public void setReceivedMessage(String receivedMessage) {
		this.receivedMessage = receivedMessage;
	}

	public BinaryMessage getBinaryMessage() {
		return binaryMessage;
	}

	public void setBinaryMessage(BinaryMessage binaryMessage) {
		this.binaryMessage = binaryMessage;
	}

	public TextMessage getTextMessage() {
		return textMessage;
	}

	public void setTextMessage(TextMessage textMessage) {
		this.textMessage = textMessage;
	}

	public MorseMessage getMorseMessage() {
		return morseMessage;
	}

	public void setMorseMessage(MorseMessage morseMessage) {
		this.morseMessage = morseMessage;
	}

	public static HashMap<String, String> getTranslationTable() {
		return TRANSLATION_TABLE;
	}
    
    
}