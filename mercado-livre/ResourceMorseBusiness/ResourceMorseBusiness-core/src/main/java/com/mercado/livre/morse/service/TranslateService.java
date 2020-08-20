package com.mercado.livre.morse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.mercado.livre.morse.entity.Message;
import com.mercado.livre.morse.entity.MorseMessage;
import com.mercado.livre.morse.entity.TranslationRequest;
import com.mercado.livre.morse.entity.TranslationResponse;
import com.mercado.livre.morse.service.helper.BinaryParserHelper;
import com.mercado.livre.morse.service.helper.BinaryTranslatorHelper;
import com.mercado.livre.morse.service.helper.MorseParserHelper;
import com.mercado.livre.morse.service.helper.MorseTranslatorHelper;
import com.mercado.livre.morse.service.helper.PulseHelper;

@Component
public class TranslateService {

	@Autowired
	private PulseHelper pulseHelper;
	@Autowired
    private BinaryTranslatorHelper binaryTranslatorHelper;
    @Autowired
    private BinaryParserHelper binaryParserHelper;
    @Autowired
    private MorseParserHelper morseParserHelper;
    @Autowired
    private MorseTranslatorHelper morseTranslatorHelper;
    
    
	public TranslationResponse decodeBits2Morse(TranslationRequest translationRequest) {
		Message message = new Message();
		message.setReceivedMessage(translationRequest.getText());
		message = pulseHelper.calculatePulseAverage(message);
		message.getBinaryMessage().setPulseValues(
				binaryParserHelper.parse(message.getReceivedMessage())
				);

		return new TranslationResponse(
				HttpStatus.OK.value(),
				binaryTranslatorHelper.messageTranslated(message)
				);
	}
	
    public TranslationResponse translateToText(TranslationRequest translationRequest) {
        Message message = new Message();
        message.setReceivedMessage(translationRequest.getText());

        MorseMessage morseMessage = new MorseMessage(
            morseParserHelper.parse(message.getReceivedMessage())
        );
        message.setMorseMessage(morseMessage);

        return new TranslationResponse(
            HttpStatus.OK.value(),
            morseTranslatorHelper.messageTranslated(message)
        );
    }

}