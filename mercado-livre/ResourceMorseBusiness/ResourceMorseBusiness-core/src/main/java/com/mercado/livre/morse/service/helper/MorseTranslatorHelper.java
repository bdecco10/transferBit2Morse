package com.mercado.livre.morse.service.helper;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.mercado.livre.morse.entity.Message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MorseTranslatorHelper extends TranslatorHelper {

	   /**
     * Repete cada valor da lista anterior da mensagem analisada
     * para obter o morseCode dos valores da tabela de tradução.
     *
     * @param message Modelo de mensagem
     * @return mensagem traduzida
     */
    @Override
    public String messageTranslated(Message message) {
        String translatedText = "";

        for (String word : message.getMorseMessage().getParsedMessage()) {
            String morseCode = Message.TRANSLATION_TABLE.entrySet()
                .stream()
                .filter(entry -> word.equalsIgnoreCase(entry.getValue()))
                .map(HashMap.Entry::getKey).findFirst().orElse(null);

            if (morseCode != null) {
                translatedText = translatedText.concat(morseCode);
            }
        }

        return translatedText;
    }}
