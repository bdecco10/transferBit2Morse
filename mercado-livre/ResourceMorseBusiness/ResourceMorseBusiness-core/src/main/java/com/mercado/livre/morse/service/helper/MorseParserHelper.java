package com.mercado.livre.morse.service.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MorseParserHelper extends ParserHelper {

	/**
     * Analisa a mensagem recebida em uma lista, se um parâmetro estiver vazio é substituído por em branco.
     *
     * @param message String mensagem
     * @return Lista de strings morseCode
     */
	
    @Override
    public List<String> parse(String message) {
        List<String> parsedMessage = new ArrayList<>(Arrays.asList(message.split("\\s")));

        parsedMessage.forEach(
            entry -> {
                if (entry.isEmpty()) {
                    parsedMessage.set(parsedMessage.indexOf(entry), " ");
                }
            }
        );
        return parsedMessage;
    }
}
