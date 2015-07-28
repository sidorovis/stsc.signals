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
}
