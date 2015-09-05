package stsc.signals;

import stsc.common.Side;
import stsc.common.signals.SerieSignal;

/**
 * Signal could be used to inform about some situation at data that require
 * positive or negative remark ({@link Side} enum) with double value. <br/>
 * You can think about that as about pair of values: {@link Side} - Double.
 */
public final class SideSignal extends SerieSignal {

	private final Side side;
	private final Double value;

	public SideSignal(final Side side, final Double value) {
		this.side = side;
		this.value = value;
	}

	public Side getSide() {
		return side;
	}

	public Double getValue() {
		return value;
	}
}
