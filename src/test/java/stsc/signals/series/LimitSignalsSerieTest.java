package stsc.signals.series;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;

import stsc.common.BadSignalException;
import stsc.signals.IntegerSignal;

public class LimitSignalsSerieTest {

	private static final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

	@Test
	public void testLimitSignalsSerie() throws BadSignalException, ParseException {
		final LimitSignalsSerie<IntegerSignal> signalSerie = new LimitSignalsSerie<>(IntegerSignal.class);

		signalSerie.addSignal(df.parse("10-10-2015"), new IntegerSignal(15));
		signalSerie.addSignal(df.parse("11-10-2015"), new IntegerSignal(18));
		signalSerie.addSignal(df.parse("13-10-2015"), new IntegerSignal(13));
		signalSerie.addSignal(df.parse("15-10-2015"), new IntegerSignal(19));
		signalSerie.addSignal(df.parse("16-10-2015"), new IntegerSignal(23));

		Assert.assertFalse(signalSerie.getSignal(0).isPresent());
		Assert.assertFalse(signalSerie.getSignal(2).isPresent());
		Assert.assertTrue(signalSerie.getSignal(df.parse("15-10-2015")).isPresent());
		Assert.assertFalse(signalSerie.getSignal(df.parse("10-10-2015")).isPresent());
		Assert.assertTrue(signalSerie.getSignal(df.parse("16-10-2015")).isPresent());

		Assert.assertEquals(5, signalSerie.size());

		Assert.assertFalse(signalSerie.getSignal(df.parse("17-10-2015")).isPresent());
	}
}
