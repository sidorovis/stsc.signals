package stsc.signals;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import stsc.common.signals.SerieSignal;
import stsc.signals.commons.KeyPair;

/**
 * SerieSignal with immutable Map of {@link KeyPair} to {@link Double} inside.
 * Can be used for example to provide signals for Correlation when there is a
 * bunch of stocks, and we want to return independent value for each pair.
 */
public final class MapKeyPairToDoubleSignal extends SerieSignal {

	private final Map<KeyPair, Double> values;

	private MapKeyPairToDoubleSignal(final Builder builder) {
		super();
		this.values = Collections.unmodifiableMap(builder.values);
	}

	public static Builder builder() {
		return new Builder();
	}

	public Map<KeyPair, Double> getValues() {
		return values;
	}

	public Double getValue(final String first, final String second) {
		return values.get(new KeyPair(first, second));
	}

	public static final class Builder {

		private final Map<KeyPair, Double> values = new HashMap<KeyPair, Double>();

		public Builder addValue(final String first, final String second, final double value) {
			return addValue(new KeyPair(first, second), value);
		}

		public Builder addValue(final KeyPair key, final Double value) {
			values.put(key, value);
			return this;
		}

		public Builder addValue(final KeyPair key, final double value) {
			values.put(key, value);
			return this;
		}

		public MapKeyPairToDoubleSignal build() {
			return new MapKeyPairToDoubleSignal(this);
		}
	}
}
