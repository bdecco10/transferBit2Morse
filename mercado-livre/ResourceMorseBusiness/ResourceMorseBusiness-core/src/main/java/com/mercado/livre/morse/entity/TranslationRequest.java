package com.mercado.livre.morse.entity;


import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TranslationRequest {

    @NotBlank(message = "Text must not be empty")
    private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
    
    
}
