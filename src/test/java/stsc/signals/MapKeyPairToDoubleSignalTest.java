package stsc.signals;

import org.junit.Assert;
import org.junit.Test;

import stsc.common.Settings;
import stsc.signals.commons.KeyPair;

public class MapKeyPairToDoubleSignalTest {

	@Test
	public void testMapKeyPairToDoubleSignal() {
		final MapKeyPairToDoubleSignal signal = MapKeyPairToDoubleSignal.builder() //
				.addValue(new KeyPair("aapl", "spy"), Double.valueOf(15.0)) //
				.addValue(new KeyPair("spy", "aapl"), Double.valueOf(12.0)) //
				.addValue(new KeyPair("spy", "idix"), Double.valueOf(6.0)) //
				.build(); //
		Assert.assertEquals(2, signal.getValues().size());
		Assert.assertEquals(12.0, signal.getValue("aapl", "spy"), Settings.doubleEpsilon);
		Assert.assertEquals(6.0, signal.getValue("spy", "idix"), Settings.doubleEpsilon);
	}
}
