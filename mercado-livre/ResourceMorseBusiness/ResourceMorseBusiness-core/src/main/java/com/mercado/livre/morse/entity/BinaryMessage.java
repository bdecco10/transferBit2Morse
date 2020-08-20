package com.mercado.livre.morse.entity;
import java.util.List;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BinaryMessage {

	private Integer maxOneValue;

    private Integer minOneValue;

    private Integer maxZeroValue;

    private Integer minZeroValue;

    private Integer endValue;

    private List<String> pulseValues;

    public enum PulseTypes {
        SHORT_ZERO(0),
        LONG_ZERO(1),
        SHORT_ONE(2),
        LONG_ONE(3),
        END(4);

        private final int value;

        PulseTypes(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

	public Integer getMaxOneValue() {
		return maxOneValue;
	}

	public void setMaxOneValue(Integer maxOneValue) {
		this.maxOneValue = maxOneValue;
	}

	public Integer getMinOneValue() {
		return minOneValue;
	}

	public void setMinOneValue(Integer minOneValue) {
		this.minOneValue = minOneValue;
	}

	public Integer getMaxZeroValue() {
		return maxZeroValue;
	}

	public void setMaxZeroValue(Integer maxZeroValue) {
		this.maxZeroValue = maxZeroValue;
	}

	public Integer getMinZeroValue() {
		return minZeroValue;
	}

	public void setMinZeroValue(Integer minZeroValue) {
		this.minZeroValue = minZeroValue;
	}

	public Integer getEndValue() {
		return endValue;
	}

	public void setEndValue(Integer endValue) {
		this.endValue = endValue;
	}

	public List<String> getPulseValues() {
		return pulseValues;
	}

	public void setPulseValues(List<String> pulseValues) {
		this.pulseValues = pulseValues;
	}
    
}