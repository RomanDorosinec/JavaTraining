package by.dorosinec.traning.miniframework;

import by.dorosinec.traning.miniframework.Command.InstructionFinal;
import by.dorosinec.traning.miniframework.Logger.Logger;

import java.util.ArrayList;

/**
 * Main class of program. Entrance point to the program
 */
public class Main {
    /**
     * Main method of the program
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            ExecutionOfAllInstruction executionOfAllInstruction = new ExecutionOfAllInstruction();
            ArrayList<Instruction> instructions = new Reader().getInstruction(args);
            ArrayList<InstructionFinal> resultsOfAllInstruction = executionOfAllInstruction.getResultsOfAllInstruction(instructions);
            Logger logger = new Logger();
            logger.makeLogFile(resultsOfAllInstruction);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
