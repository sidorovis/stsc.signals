package stsc.signals;

import stsc.common.signals.SerieSignal;

/**
 * Signal that store integer value inside.
 */
public final class IntegerSignal extends SerieSignal {

	private final Integer value;

	public IntegerSignal(final int value) {
		this.value = Integer.valueOf(value);
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value.toString();
	}

}
