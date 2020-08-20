package com.mercado.livre.morse.service.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tlf.oss.common.log.OSSLogger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BinaryParserHelper extends ParserHelper {

    /**
	 *  Analise a mensagem recebida em uma lista, usando regex para obter apenas parâmetros binários
     * se a mensagem não tiver caracteres binários, ela retornará uma lista vazia.
     *
     * @param message String mensagem
     * @return Lista de strings divididas por zeros ou uns
     */
	@Inject
	private OSSLogger logger;
	
    @Override
    public List<String> parse(String message) {
        List<String> binaryParsedMessage = new ArrayList<>();
        Matcher m = Pattern.compile("(0+|1+)").matcher(message);

        while(m.find()) {
            binaryParsedMessage.add(m.group(1));
        }

        logger.log(OSSLogger.INFO, "binaryParsedMessage: {}"+ binaryParsedMessage);

        return binaryParsedMessage;
    }
}
