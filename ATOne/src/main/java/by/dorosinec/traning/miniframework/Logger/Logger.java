package by.dorosinec.traning.miniframework.Logger;

import by.dorosinec.traning.miniframework.Command.InstructionFinal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * This class write in .txt file
 */
public class Logger {
    private static final String LOG_FILE = "logFile.txt";

    /**
     * Method vhich write in log file
     * @param lists list of object which contain: test performed or not;
     *                         object Instruction(which contain: name of instruction and other arguments);
     *                         lead time
     */
    public void makeLogFile(ArrayList<InstructionFinal> lists) throws Exception {
        File logFile = new File(LOG_FILE);
        BufferedWriter writer = new BufferedWriter(new FileWriter(logFile));
        WriteInTheLogFile writeInTheLogFile = new WriteInTheLogFile();
        BigDecimal totalTime = BigDecimal.valueOf(0);
        for (InstructionFinal list : lists) {
            writer.write(writeInTheLogFile.write(writer, list));
            totalTime = totalTime.add(list.getFinalTime());
        }
        writer.write("Total tests: " + lists.size() + "\n");
        writer.write("Passed/Failed: " + writeInTheLogFile.passedOrFailed(lists) + "\n");
        writer.write("Total time: " + totalTime  + "\n");
        writer.write("Average time: " + totalTime.divide(BigDecimal.valueOf(lists.size())) + "\n");
        writer.flush();
        writer.close();
    }
}
