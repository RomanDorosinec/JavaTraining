package by.dorosinec.traning.miniframework.Command;

import by.dorosinec.traning.miniframework.Instruction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.util.List;

/**
 * Class of executing instruction "CheckLinkPresentByHref"
 */
public class InstructionCheckLinkPresentByHref extends InstructionImplementation {
    /**
     * Method for checking instruction to execute
     * @param instruction instruction to be executed
     * @return
     */
    @Override
    public boolean canExecution(Instruction instruction) {
        return instruction.getNameCommand().equals(Instruction.CHECK_LINE_PRESENT_BY_HREF);
    }

    /**
     * Method which executing instruction "CheckLinkPresentByHref"
     * @param instruction instruction to be executed
     * @param driver      WebDriver object
     * @return object which contain: test performed or not;
     *                         object Instruction(which contain: name of instruction and other arguments);
     *                         lead time
     */
    @Override
    public InstructionFinal commandExecution(Instruction instruction, WebDriver driver) throws Exception {
        BigDecimal firstTime = new BigDecimal(System.currentTimeMillis());
        List<WebElement> elements = driver.findElements(By.xpath("a"));
        boolean flag = false;
        for (WebElement element: elements) {
           if (element.getAttribute("href").equals(instruction.getArg1())) {
                flag = true;
           }
        }
        BigDecimal secondTime = new BigDecimal(System.currentTimeMillis());
        return new InstructionFinal(true, instruction, getRunTime(firstTime, secondTime));
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
