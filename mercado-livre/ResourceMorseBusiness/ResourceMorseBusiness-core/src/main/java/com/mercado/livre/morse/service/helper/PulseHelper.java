package com.mercado.livre.morse.service.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mercado.livre.morse.entity.BinaryMessage;
import com.mercado.livre.morse.entity.Message;
import com.tlf.oss.common.log.OSSLogger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PulseHelper {
	
	@Inject
	private OSSLogger logger;
    /**
     * Avalia cada caractere de um pulso de string para saber o tipo de pulso a ser manipulado.
     *
     * @param pulso pulso valor
     * @param maxOneValue número máximo de aparições para o valor um
     * @param maxZeroValue número máximo de aparições para o valor zero
     * @param minOneValue número mínimo de aparições para o valor um
     * @param minZeroValue número máximo de aparições para o valor zero
     * @param finalValue finalValue da mensagem
     * @return Inteiro que representa o tipo de pulso
     */
	
    public Integer evaluatePulses(String pulse, int maxOneValue, int maxZeroValue, int minOneValue, int minZeroValue, int finalValue) {
        Integer pulses = null;

        if (pulse != null && pulse.length() > 0) {
            Character pulseType = pulse.charAt(0);

            if (pulseType.equals('1')) {
                if (pulse.length() < ((maxOneValue + minOneValue) / 2)) {
                    pulses = BinaryMessage.PulseTypes.SHORT_ONE.getValue();
                } else {
                    pulses = BinaryMessage.PulseTypes.LONG_ONE.getValue();
                }
            } else if (pulseType.equals('0')) {
                if (pulse.length() < ((maxZeroValue + minZeroValue) / 2)) {
                    pulses = BinaryMessage.PulseTypes.SHORT_ZERO.getValue();
                } else if (pulse.length() == finalValue) {
                    pulses = BinaryMessage.PulseTypes.END.getValue();
                } else {
                    pulses = BinaryMessage.PulseTypes.LONG_ZERO.getValue();
                }
            }
        }

        logger.log(OSSLogger.INFO, "Number: {}, pulses: {} "+pulse +"-"+ pulses);
        return pulses;
    }

    /**
     * Calculates the min and max appearances for 0 or 1 pulses
     * The first and last value matching 0 is always ignored
     * All the values calculated are logged.
     * @param message Messaged model
     * @return Message model with calculated values for the BinaryMessage Model
     */
    public Message calculatePulseAverage(Message message) {
        String receivedMessage = message.getReceivedMessage();

        List<String> zeroPulses = new ArrayList<>(
            Arrays.asList(
                receivedMessage.replaceAll("(1+)", " ").trim().split(" ")
            )
        );

        List<String> onePulses =  new ArrayList<>(
            Arrays.asList(
                receivedMessage.replaceAll("(0+)", " ").trim().split(" ")
            )
        );

        String finalBit = "";
        if (!zeroPulses.isEmpty()) {
            List<String> zeroPulsesCopy = new ArrayList<>(zeroPulses);
            zeroPulses.remove(zeroPulsesCopy.get(0));
            zeroPulses.remove(zeroPulsesCopy.get((zeroPulsesCopy.size() - 1)));
            finalBit = zeroPulsesCopy.get((zeroPulsesCopy.size() - 1));
        }


        logger.log(OSSLogger.INFO,"ones: {} "+ onePulses);
        logger.log(OSSLogger.INFO,"zeros: {} "+ zeroPulses);

        BinaryMessage binaryMessage = new BinaryMessage();

        binaryMessage.setMaxOneValue(onePulses.stream().map(String::length).max(Integer::compareTo).get());
        binaryMessage.setMinOneValue(onePulses.stream().map(String::length).min(Integer::compareTo).get());
        binaryMessage.setMaxZeroValue(
            zeroPulses.stream().map(String::length).max(Integer::compareTo).isPresent() ?
                zeroPulses.stream().map(String::length).max(Integer::compareTo).get() : 0
        );
        binaryMessage.setMinZeroValue(
            zeroPulses.stream().map(String::length).min(Integer::compareTo).isPresent() ?
                zeroPulses.stream().map(String::length).min(Integer::compareTo).get() : 0
        );
        binaryMessage.setEndValue(finalBit.length());
        message.setBinaryMessage(binaryMessage);

        logger.log(OSSLogger.INFO,"avgMaxOne: {}"+ binaryMessage.getMaxOneValue());
        logger.log(OSSLogger.INFO,"avgMinOne: {}"+ binaryMessage.getMinOneValue());
        logger.log(OSSLogger.INFO,"avgMaxZero: {}"+ binaryMessage.getMaxZeroValue());
        logger.log(OSSLogger.INFO,"avgMinCero: {}"+ binaryMessage.getMinZeroValue());
        logger.log(OSSLogger.INFO,"endValue: {}"+ binaryMessage.getEndValue());

        return message;
    }
}
