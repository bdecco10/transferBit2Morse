package com.mercado.livre.morse.service.helper;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercado.livre.morse.entity.BinaryMessage;
import com.mercado.livre.morse.entity.Message;
import com.tlf.oss.common.log.OSSLogger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BinaryTranslatorHelper extends TranslatorHelper {

    @Autowired
    private PulseHelper pulseHelper;

    /**
     * Usa os valores de pulso da mensagem binária para obter uma lista de pulsos como string
     * e então usa o pulseHelper para avaliar cada um e mudar para o valor adequado.
     *
     * @param message Modelo de mensagem
     * @return mensagem traduzida
     */
	@Inject
	private OSSLogger logger;
    @Override
    public String messageTranslated(Message message) {
        String decodedMessage = "";
        BinaryMessage binaryMessage = message.getBinaryMessage();

        for (String p : binaryMessage.getPulseValues()) {
            logger.log(OSSLogger.INFO, "pulso: {}"+ p);

            Integer evaluatedPulse = pulseHelper.evaluatePulses(
                p,
                binaryMessage.getMaxOneValue(),
                binaryMessage.getMaxZeroValue(),
                binaryMessage.getMinOneValue(),
                binaryMessage.getMinZeroValue(),
                binaryMessage.getEndValue()
            );

            switch (evaluatedPulse) {
                case 0:
                case 4:
                    decodedMessage = decodedMessage.concat("");
                    break;
                case 1:
                    decodedMessage = decodedMessage.concat(" ");
                    break;
                case 2:
                    decodedMessage = decodedMessage.concat(".");
                    break;
                case 3:
                    decodedMessage = decodedMessage.concat("-");
                    break;
            }
        }

        logger.log(OSSLogger.INFO, "Decoded message: {} "+ decodedMessage);
        return decodedMessage;
    }
}
