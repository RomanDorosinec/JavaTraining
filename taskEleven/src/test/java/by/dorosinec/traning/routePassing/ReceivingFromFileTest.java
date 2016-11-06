package by.dorosinec.traning.routePassing;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class test ReceivengFromFileTest
 */
public class ReceivingFromFileTest {
    @Test
    public void validateDataOfFile() throws Exception {
        ReceivingFromFile receivingFromFile = new ReceivingFromFile();
        String line = "";
        receivingFromFile.validateDataOfFile(line);
    }

}