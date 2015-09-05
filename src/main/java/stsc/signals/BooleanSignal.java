package stsc.signals;

import stsc.common.signals.SerieSignal;

/**
 * Signal can be used for showing some simple boolean value. For example
 * "we have data", "this value is necessary", "start trading".
 */
public final class BooleanSignal extends SerieSignal {

	private final Boolean value;

	public BooleanSignal(final boolean value) {
		this.value = new Boolean(value);
	}

	@Override
	public String toString() {
		return value.toString();
	}

	public boolean getValue() {
		return value;
	}

}
