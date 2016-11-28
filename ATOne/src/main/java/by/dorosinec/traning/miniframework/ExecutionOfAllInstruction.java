package by.dorosinec.traning.miniframework;

import by.dorosinec.traning.miniframework.Command.InstructionBuilder;
import by.dorosinec.traning.miniframework.Command.InstructionFinal;
import by.dorosinec.traning.miniframework.Command.InstructionImplementation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.AbstractList;
import java.util.ArrayList;

/**
 * Class of Execution Instructions
 */
public class ExecutionOfAllInstruction {
    private static final String CHROME_PROPERTY_NAME = "webdriver.gecko.driver";
    private static final String WINDOWS_DEFAULT_CHROME_PATH = "geckodriver.exe";

    /**
     * Method get results executing instruction
     *
     * @param instructions list of instruction
     * @return the list executing instructions of the results
     */
    public ArrayList<InstructionFinal> getResultsOfAllInstruction(AbstractList<Instruction> instructions) throws Exception {
        ArrayList<InstructionFinal> instructionFinals = new ArrayList<>();
        System.setProperty(CHROME_PROPERTY_NAME, WINDOWS_DEFAULT_CHROME_PATH);
        WebDriver driver = new FirefoxDriver();
        for (Instruction instruction : instructions) {
            instructionFinals.add(getResultOfInstruction(instruction, driver));
        }
        driver.quit();
        return instructionFinals;
    }

    /**
     * Method gets the result of a single statement
     *
     * @param instruction one of the instructions to be executed
     * @param driver      WebDriver
     * @return
     */
    public InstructionFinal getResultOfInstruction(Instruction instruction, WebDriver driver) throws Exception {
        ArrayList<InstructionImplementation> instructionBuilder = new InstructionBuilder().getInstructionBuild();
        InstructionFinal instructionFinal = new InstructionFinal();
        for (InstructionImplementation implementation : instructionBuilder) {
            if (implementation.canExecution(instruction)) {
                instructionFinal = implementation.commandExecution(instruction, driver);
            }
        }
        return instructionFinal;
    }
}
