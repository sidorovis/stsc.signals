package stsc.signals;

import stsc.common.signals.SerieSignal;

/**
 * {@link DoubleSignal} - the most widely used and common signal for all series.
 * People always tried to describe world with double numbers.
 */
public final class DoubleSignal extends SerieSignal {

	final private double value;

	public DoubleSignal(final double value) {
		this.value = Double.valueOf(value);
	}

	public double getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

}
