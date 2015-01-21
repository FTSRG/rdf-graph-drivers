package eu.mondo.driver.fourstore.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import eu.mondo.driver.fourstore.FourStoreGraphDriverRead;
import eu.mondo.driver.graph.test.RDFGraphDriverReadTest;

public class FourStoreGraphDriverReadTest extends RDFGraphDriverReadTest {

	protected static FourStoreGraphDriverRead fourStoreDriver;

	@BeforeClass
	public static void setUp() throws FileNotFoundException, IOException, InterruptedException {
		String connectionString = "fourstore://trainbenchmark_cluster";
		driver = fourStoreDriver = new FourStoreGraphDriverRead(connectionString);

		fourStoreDriver.start();
		File file = new File("src/test/resources/models/railway-xform-1.ttl");
		fourStoreDriver.load(file.getAbsolutePath());
	}

	@AfterClass
	public static void tearDown() throws FileNotFoundException, IOException {
		fourStoreDriver.stop();
	}

}