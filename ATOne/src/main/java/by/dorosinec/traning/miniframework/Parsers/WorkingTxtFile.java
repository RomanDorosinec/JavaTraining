package by.dorosinec.traning.miniframework.Parsers;

import by.dorosinec.traning.miniframework.Instruction;

import java.io.*;
import java.util.ArrayList;

/**
 * Class working with .txt file
 */
public class WorkingTxtFile {
    /**
     * Method for get all instruction
     *
     * @param filePath path to .txt file
     * @return list of instruction
     * @throws Exception if .txt file not exist
     */
    public ArrayList<Instruction> getLine(String filePath) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
        ArrayList<Instruction> paramInstruction = new ArrayList<Instruction>();
        String nextLine = reader.readLine();
        while (nextLine != null) {
            paramInstruction.add(new Instruction().parseInstruction(getParamsOfInstruction(getInstruction(nextLine))));
            nextLine = reader.readLine();
        }
        return paramInstruction;
    }

    /**
     * Method that determines whether or not the line of the file command.
     * If an instruction removes the "--"
     *
     * @param line line of .txt file
     * @return correct line of instruction
     * @throws Exception if line start not "--"
     */
    public String getInstruction(String line) throws Exception {
        String correctInstruction;
        if (line.startsWith("--")) {
            correctInstruction = line.substring(2, line.length());
        } else {
            throw new Exception("This is not instruction. Instruction should start \"--\"!");
        }
        return correctInstruction;
    }

    /**
     * Method which receives all instructions arguments
     *
     * @param correctInstruction line of .txt file
     * @return arrayList with all parameters of instruction
     */
    private ArrayList<String> getParamsOfInstruction(String correctInstruction) {
        ArrayList<String> paramInstruction = new ArrayList<String>();
        int firstElement = correctInstruction.indexOf("\"");
        int secondElement = correctInstruction.indexOf("\"", firstElement + 1);
        paramInstruction.add(correctInstruction.substring(0, firstElement).trim());
        while (firstElement != -1) {
            paramInstruction.add(correctInstruction.substring(firstElement + 1, secondElement).trim());
            firstElement = correctInstruction.indexOf("\"", secondElement + 1);
            secondElement = correctInstruction.indexOf("\"", firstElement + 1);
        }
        return paramInstruction;
    }
}
