package by.dorosinec.traning.miniframework;

import java.util.ArrayList;

/**
 * Class of entered instruction
 */
public class Instruction {
    public static final String OPEN = "open";
    public static final String CHECK_LINE_PRESENT_BY_HREF = "checkLinkPresentByHref";
    public static final String CHECK_LINE_PRESENT_BY_NAME = "checkLinePresentByName";
    public static final String CHECK_PAGE_TITLE = "checkPageTitle";
    public static final String CHECK_PAGE_CONTAINS = "checkPageContains";
    public static final String NAME_INSTRUCTION = "instruction";
    public static final String ARG1 = "arg1";
    public static final String ARG2 = "arg2";

    private String nameInstruction;
    private String arg1;
    private String arg2;

    /**
     * Construction of class.This constructor will be used if a team has only two parameters
     *
     * @param name instruction name entered
     * @param arg1 arguments of instruction
     */
    public Instruction(String name, String arg1) {
        this.nameInstruction = name;
        this.arg1 = arg1;
    }

    /**
     * Construction of class.This constructor will be used if a team has only three parameters
     *
     * @param name instruction name entered
     * @param arg1 arguments of instruction
     * @param arg2 arguments of instruction
     */
    public Instruction(String name, String arg1, String arg2) {
        this.nameInstruction = name;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public Instruction() {

    }

    public String getArg2() {
        return arg2;
    }

    public String getArg1() {
        return arg1;
    }

    public String getNameCommand() {
        return nameInstruction;
    }

    /**
     * method creates an object of instruction according to the input parameters
     *
     * @param listInstruction a list of all the parameters of a single statement
     * @return object of instruction
     * @throws Exception if instruction have more parameters or instruction doesn't have parameters
     */
    public Instruction parseInstruction(ArrayList<String> listInstruction) throws Exception {
        Instruction instruction;
        ArrayList<String> paramInstruction = listInstruction;
        switch (paramInstruction.size()) {
            case 3:
                instruction = new Instruction(paramInstruction.get(0), paramInstruction.get(1), paramInstruction.get(2));
                break;
            case 2:
                instruction = new Instruction(paramInstruction.get(0), paramInstruction.get(1));
                break;
            case 1:
                throw new Exception("Instruction does not contain parameters!");
            default:
                throw new Exception("Instruction contains more parameters than necessary");
        }
        return instruction;
    }
}
