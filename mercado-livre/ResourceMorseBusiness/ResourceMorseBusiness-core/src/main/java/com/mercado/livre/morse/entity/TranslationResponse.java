package com.mercado.livre.morse.entity;

public class TranslationResponse {

    private int code;

    private String response;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public TranslationResponse(int code, String response) {
		this.code = code;
		this.response = response;
	}
    
}