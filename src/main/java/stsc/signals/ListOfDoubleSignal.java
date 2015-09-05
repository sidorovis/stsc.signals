package stsc.signals;

import java.util.ArrayList;
import java.util.List;

import stsc.common.signals.SerieSignal;

/**
 * This signal store list of double's inside. Used by geometry algorithms (for
 * example used to describe ax + b = 0 like (so 'a' goes to element with 0
 * index, and 'b' goes to element with 1 index).
 */
public final class ListOfDoubleSignal extends SerieSignal {

	private final List<Double> values = new ArrayList<>();

	public ListOfDoubleSignal() {
	}

	public ListOfDoubleSignal add(final double element) {
		values.add(element);
		return this;
	}

	public ListOfDoubleSignal addDouble(final double element) {
		values.add(element);
		return this;
	}

	public List<Double> getValues() {
		return values;
	}

	@Override
	public String toString() {
		return values.toString();
	}

}
