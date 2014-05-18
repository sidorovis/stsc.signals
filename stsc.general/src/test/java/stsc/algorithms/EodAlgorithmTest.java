package stsc.algorithms;

import java.util.Date;
import java.util.HashMap;

import stsc.common.Day;
import stsc.signals.BadSignalException;
import stsc.signals.EodSignal;
import stsc.testhelper.TestAlgorithmsHelper;
import junit.framework.TestCase;

public class EodAlgorithmTest extends TestCase {

	private static class EodAlgorithmHelper extends EodAlgorithm {

		protected EodAlgorithmHelper(EodAlgorithm.Init init) throws BadAlgorithmException {
			super(init);
		}

		@Override
		public Class<? extends EodSignal> registerSignalsClass() {
			return EodSignal.class;
		}

		@Override
		public void process(Date date, HashMap<String, Day> datafeed) throws BadSignalException {
			addSignal(date, new EodSignal());
		}

	}

	public void testEodAlgorithm() throws BadSignalException, BadAlgorithmException {
		EodAlgorithm.Init init = TestAlgorithmsHelper.getEodAlgorithmInit();
		init.executionName = "a";
		EodAlgorithmHelper eah = new EodAlgorithmHelper(init);
		final Date theDate = new Date();
		eah.process(new Date(), new HashMap<String, Day>());
		assertEquals(EodSignal.class, init.signalsStorage.getEodSignal("a", theDate).getSignal(EodSignal.class)
				.getClass());
	}
}
