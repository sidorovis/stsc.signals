package stsc.signals.commons;

import org.junit.Assert;
import org.junit.Test;

public class KeyPairTest {

	@Test
	public void testKeyPair() {
		final KeyPair kp = new KeyPair("asd", "sdf");
		Assert.assertEquals(kp, kp);
		Assert.assertEquals(new KeyPair("asd", "sdf"), kp);
		Assert.assertNotEquals(new KeyPair("asd", "sdF"), kp);
		Assert.assertNotEquals(new KeyPair("asD", "sdf"), kp);
		Assert.assertNotEquals(new KeyPair("2", "sdf"), kp);
		Assert.assertNotEquals(new KeyPair("asd", "2"), kp);
		Assert.assertNotEquals(new KeyPair("asd", "sd"), kp);
		Assert.assertNotEquals(new KeyPair("as", "sdf"), kp);

		Assert.assertEquals("sdf", new KeyPair("asd", "sdf").getRight());
		Assert.assertEquals("sdf", new KeyPair("sdf", "asd").getRight());

		Assert.assertEquals("asd", new KeyPair("asd", "sdf").getLeft());
		Assert.assertEquals("asd", new KeyPair("sdf", "asd").getLeft());
	}

	@Test
	public void testKeyPairComparable() {
		final KeyPair a = new KeyPair("asd", "sdf");
		final KeyPair b = new KeyPair("asd", "sdf2");
		Assert.assertEquals(-1, a.compareTo(b));
		Assert.assertEquals(1, b.compareTo(a));
		Assert.assertEquals(0, b.compareTo(new KeyPair("asd", "sdf2")));
		Assert.assertTrue(0 < b.compareTo(new KeyPair("asd", "adf")));
		Assert.assertTrue(0 < b.compareTo(new KeyPair("abf", "sdf2")));
		Assert.assertTrue(0 > b.compareTo(new KeyPair("azf", "sdf2")));
	}

	@Test
	public void testKeyPairContains() {
		final KeyPair a = new KeyPair("asd", "xcvt");
		Assert.assertTrue(a.contain("asd"));
		Assert.assertTrue(a.contain("xcvt"));
		Assert.assertFalse(a.contain("sdf"));
	}
}
