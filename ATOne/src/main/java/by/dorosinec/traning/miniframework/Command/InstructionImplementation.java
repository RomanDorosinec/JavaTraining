package by.dorosinec.traning.miniframework.Command;

import by.dorosinec.traning.miniframework.Instruction;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

/**
 * Instruction implementation class. This class should be extends by others instruction
 */
public abstract class InstructionImplementation {
    /**
     * Method for checking instruction to impemetation
     *
     * @param instruction instruction to be executed
     * @return true if this instruction can be performed
     */
    public abstract boolean canExecution(Instruction instruction);
    /**
     * Method for implementation instruction
     *
     * @param instruction instruction to be executed
     * @param driver      WebDriver object
     */
    public abstract InstructionFinal commandExecution(Instruction instruction, WebDriver driver) throws Exception;

    /**
     * Method for calculating run time of instruction
     *
     * @param firstTime  start time of instruction
     * @param secondTime end time of instruction
     * @return runtime of command in seconds
     */
    public abstract BigDecimal getRunTime(BigDecimal firstTime, BigDecimal secondTime);
}
