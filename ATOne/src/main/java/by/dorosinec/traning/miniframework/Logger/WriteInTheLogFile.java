package by.dorosinec.traning.miniframework.Logger;

import by.dorosinec.traning.miniframework.Command.InstructionFinal;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class make line of log file
 */
public class WriteInTheLogFile {
    /**
     * Method make one line of log file
     *
     * @param writer buffered character-output stream
     * @param instructionFinal object which contain: test performed or not;
     *                         object Instruction(which contain: name of instruction and other arguments);
     *                         lead time
     * @return line of log file
     */
    public String write(BufferedWriter writer, InstructionFinal instructionFinal) throws IOException {
        String lineOfLogFile;
        String doORnot;
        if (instructionFinal.isCanExecution()) {
            doORnot = "+ [";
        } else {
            doORnot = "! [";
        }
        if (instructionFinal.getInstruct().getArg2() == null) {
            lineOfLogFile = doORnot + instructionFinal.getInstruct().getNameCommand() + " \""
                    + instructionFinal.getInstruct().getArg1() + "\"] " + instructionFinal.getFinalTime() + "\n";
        } else {
            lineOfLogFile = doORnot + instructionFinal.getInstruct().getNameCommand() + " \""
                    + instructionFinal.getInstruct().getArg1() + "\" \""
                    + instructionFinal.getInstruct().getArg2() + "\"] " + instructionFinal.getFinalTime() + "\n";
        }
        return lineOfLogFile;
    }

    /**
     * Method receives as much as there is no test is performed
     *
     * @param lists list of information about the execution of tests
     * @return line of passed/failed; example: 3/4
     */
    public String passedOrFailed(ArrayList<InstructionFinal> lists) {
        int countPassed = 0;
        int countFailed = 0;
        for (InstructionFinal instructionFinal : lists) {
            if (instructionFinal.isCanExecution()) {
                countPassed++;
            } else {
                countFailed++;
            }
        }
        String countTests = String.valueOf(countPassed) + "/" + String.valueOf(countFailed);
        return countTests;
    }
}
