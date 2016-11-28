package by.dorosinec.traning.miniframework.Command;

import by.dorosinec.traning.miniframework.Instruction;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

/**
 * Class of executing instruction "CheckPageContains"
 */
public class InstructionCheckPageContains extends InstructionImplementation {
    /**
     * Method for checking instruction to execute
     * @param instruction instruction to be executed
     * @return instruction can be executed or not
     */
    @Override
    public boolean canExecution(Instruction instruction) {
        return instruction.getNameCommand().equals(Instruction.CHECK_PAGE_CONTAINS);
    }

    /**
     * Method which executing instruction "CheckPageContains"
     * @param instruction instruction to be executed
     * @param driver      WebDriver object
     * @return object which contain: test performed or not;
     *                         object Instruction(which contain: name of instruction and other arguments);
     *                         lead time
     */
    @Override
    public InstructionFinal commandExecution(Instruction instruction, WebDriver driver) throws Exception {
        BigDecimal firstTime = new BigDecimal(System.currentTimeMillis());
        boolean flag = driver.getPageSource().contains(instruction.getArg1());
        BigDecimal secondTime = new BigDecimal(System.currentTimeMillis());
        return new InstructionFinal(flag, instruction, getRunTime(firstTime, secondTime));
    }

    /**
     * Method for calculating runtime of instruction
     * @param firstTime  start time of instruction
     * @param secondTime end time of instruction
     * @return time executing the command
     */
    @Override
    public BigDecimal getRunTime(BigDecimal firstTime, BigDecimal secondTime) {
        return secondTime.subtract(firstTime).divide(BigDecimal.valueOf(1000));
    }
}
