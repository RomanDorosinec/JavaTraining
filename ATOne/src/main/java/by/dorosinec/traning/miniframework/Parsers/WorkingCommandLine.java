package by.dorosinec.traning.miniframework.Parsers;

import by.dorosinec.traning.miniframework.Instruction;

import java.util.ArrayList;

/**
 * Class working with command line arguments
 */
public class WorkingCommandLine {
    /**
     * Method for get all instruction
     *
     * @param args command line arguments
     * @return list of instruction
     * @throws Exception if .txt file not exist
     */
    public ArrayList<Instruction> getLine(String[] args) throws Exception {
        String line = null;
        ArrayList<Instruction> paramInstruction = new ArrayList<Instruction>();
        for (int i = 0; i < args.length; ) {
            if (args[i].startsWith("--")) {
                line = args[i];
                i++;
            } else {
                while (i < args.length && !args[i].startsWith("--")) {
                    line += "\"" + args[i];
                    i++;
                }
                paramInstruction.add(new Instruction().parseInstruction(getParamsOfInstruction(getInstruction(line))));
            }
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
        ArrayList<String> paramInstruction = new ArrayList<>();
        String[] helpArray = correctInstruction.split("\"");
        for (int i = 0; i < helpArray.length; i++) {
            paramInstruction.add(helpArray[i]);
        }
        return paramInstruction;
    }
}
