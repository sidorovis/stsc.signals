package stsc.signals;

import org.junit.Assert;
import org.junit.Test;

public class BooleanSignalTest {

	@Test
	public void testBooleanSignal() {
		final BooleanSignal bsTrue = new BooleanSignal(true);
		Assert.assertEquals(true, bsTrue.getValue());
		final BooleanSignal bsFalse = new BooleanSignal(false);
		Assert.assertEquals(false, bsFalse.getValue());
	}
}
