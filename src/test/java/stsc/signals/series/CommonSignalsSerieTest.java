package stsc.signals.series;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;

import stsc.common.BadSignalException;
import stsc.signals.IntegerSignal;

public class CommonSignalsSerieTest {

	private static final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

	@Test
	public void testCommonSignalsSerie() throws BadSignalException, ParseException {
		final CommonSignalsSerie<IntegerSignal> signalSerie = new CommonSignalsSerie<>(IntegerSignal.class);

		signalSerie.addSignal(df.parse("10-10-2015"), new IntegerSignal(15));
		signalSerie.addSignal(df.parse("11-10-2015"), new IntegerSignal(18));
		signalSerie.addSignal(df.parse("13-10-2015"), new IntegerSignal(13));
		signalSerie.addSignal(df.parse("15-10-2015"), new IntegerSignal(19));
		signalSerie.addSignal(df.parse("16-10-2015"), new IntegerSignal(23));

		Assert.assertEquals(18, signalSerie.getSignal(1).getContent().getValue());
		Assert.assertEquals(19, signalSerie.getSignal(3).getContent().getValue());
		Assert.assertEquals(19, signalSerie.getSignal(df.parse("15-10-2015")).getContent().getValue());
		Assert.assertEquals(15, signalSerie.getSignal(df.parse("10-10-2015")).getContent().getValue());

		Assert.assertEquals(5, signalSerie.size());

		Assert.assertNull(signalSerie.getSignal(df.parse("17-10-2015")));
	}
}
