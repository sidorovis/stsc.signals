package stsc.testhelper;

import java.util.Date;

import org.joda.time.LocalDate;

import stsc.common.FromToPeriod;
import stsc.common.Side;
import stsc.statistic.Statistics;
import stsc.statistic.StatisticsProcessor;
import stsc.stocks.Stock;
import stsc.stocks.UnitedFormatStock;
import stsc.trading.BrokerImpl;
import stsc.trading.TradingLog;

public class TestHelper {

	public static FromToPeriod getPeriod() {
		try {
			return new FromToPeriod("01-01-2000", "31-12-2009");
		} catch (Exception e) {
		}
		return null;
	}

	public static Statistics getStatistics() {
		return getStatistics(100, 200);
	}

	public static Statistics getStatistics(int applSize, int admSize) {
		Statistics statisticsData = null;
		try {
			Stock aapl = UnitedFormatStock.readFromUniteFormatFile("./test_data/aapl.uf");
			Stock adm = UnitedFormatStock.readFromUniteFormatFile("./test_data/adm.uf");

			int aaplIndex = aapl.findDayIndex(new LocalDate(2013, 9, 4).toDate());
			int admIndex = adm.findDayIndex(new LocalDate(2013, 9, 4).toDate());

			TradingLog tradingLog = new BrokerImpl(TestStockStorageHelper.getStockStorage()).getTradingLog();

			StatisticsProcessor statistics = new StatisticsProcessor(tradingLog);

			statistics.setStockDay("aapl", aapl.getDays().get(aaplIndex++));
			statistics.setStockDay("adm", adm.getDays().get(admIndex++));

			tradingLog.addBuyRecord(new Date(), "aapl", Side.LONG, applSize);
			tradingLog.addBuyRecord(new Date(), "adm", Side.SHORT, admSize);

			statistics.processEod();

			statistics.setStockDay("aapl", aapl.getDays().get(aaplIndex++));
			statistics.setStockDay("adm", adm.getDays().get(admIndex++));

			tradingLog.addSellRecord(new Date(), "aapl", Side.LONG, applSize);
			tradingLog.addSellRecord(new Date(), "adm", Side.SHORT, admSize);

			statistics.processEod();

			statisticsData = statistics.calculate();

		} catch (Exception e) {
		}
		return statisticsData;
	}

}
