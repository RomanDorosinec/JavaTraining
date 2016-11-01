package by.dorosinec.traning.routePassing;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * Class test ReceivengFromFileTest
 */
public class ReceivingFromFileTest {
    @Test(expectedExceptions = Exception.class)
    public void validateDataOfFile() throws Exception {
        new ReceivingFromFile().validateDataOfFile(null);
    }

}