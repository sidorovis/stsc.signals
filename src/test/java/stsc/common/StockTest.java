package stsc.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;

import junit.framework.TestCase;

public class StockTest extends TestCase {

	public void testStockGenerate() throws IOException, ParseException {
		assertEquals(1, UnitedFormatStock.readFromCsvFile("anse", "./test_data/anse.csv").getDays().size());
		assertEquals(105, UnitedFormatStock.readFromCsvFile("aahc", "./test_data/aahc.csv").getDays().size());
		assertEquals(75, UnitedFormatStock.readFromCsvFile("aaoi", "./test_data/aaoi.csv").getDays().size());
		assertEquals(13098, UnitedFormatStock.readFromCsvFile("ibm", "./test_data/ibm.csv").getDays().size());
	}

	public void testStockStore() throws IOException, ParseException, ClassNotFoundException {
		{
			StockInterface s = UnitedFormatStock.readFromCsvFile("aaoi", "./test_data/aaoi.csv");
			OutputStream os = new BufferedOutputStream(new FileOutputStream("./test/aaoi.bin"));
			ObjectOutput oo = new ObjectOutputStream(os);
			oo.writeObject(s);
			oo.close();
		}
		{
			InputStream is = new BufferedInputStream(new FileInputStream("./test/aaoi.bin"));
			ObjectInput oi = new ObjectInputStream(is);
			StockInterface s = null;
			s = (StockInterface) oi.readObject();
			oi.close();
			assertEquals(75, s.getDays().size());
		}
		(new File("./test/aaoi.bin")).delete();
	}

	public void testGeneratePartiallyDownloadLine() throws IOException, ParseException {
		UnitedFormatStock aaoi = UnitedFormatStock.readFromCsvFile("aaoi", "./test_data/aaoi.csv");
		assertEquals("http://ichart.yahoo.com/table.csv?s=aaoi&a=0&b=14&c=2014", aaoi.generatePartiallyDownloadLine());
		UnitedFormatStock aahc = UnitedFormatStock.readFromCsvFile("aahc", "./test_data/aahc.csv");
		assertEquals("http://ichart.yahoo.com/table.csv?s=aahc&a=5&b=4&c=2013", aahc.generatePartiallyDownloadLine());
	}

	public void testAddDaysFromString() throws IOException, ParseException {
		UnitedFormatStock aaoi = UnitedFormatStock.readFromCsvFile("aaoi", "./test_data/aaoi.csv");
		byte[] data = Files.readAllBytes(Paths.get("./test_data/aaoi_add.csv"));
		String content = new String(data);
		aaoi.addDaysFromString(content);
		assertEquals(91, aaoi.getDays().size());
	}

	public void testUniteFormat() throws IOException, ParseException {
		UnitedFormatStock s = UnitedFormatStock.readFromCsvFile("aaoi", "./test_data/aaoi.csv");
		s.storeUniteFormat("./test/aaoi.uf");
		StockInterface s_copy = UnitedFormatStock.readFromUniteFormatFile("./test/aaoi.uf");
		assertEquals("aaoi", s_copy.getName());
		new File("./test/aaoi.uf").delete();
		assertEquals(75, s_copy.getDays().size());
		assertEquals(75, s.getDays().size());
	}
}