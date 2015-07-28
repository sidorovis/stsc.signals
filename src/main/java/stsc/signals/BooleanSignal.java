package stsc.signals;

import stsc.common.signals.SerieSignal;

public final class BooleanSignal extends SerieSignal {

	final public Boolean value;

	public BooleanSignal(final boolean value) {
		this.value = new Boolean(value);
	}

	@Override
	public String toString() {
		return value.toString();
	}

}
