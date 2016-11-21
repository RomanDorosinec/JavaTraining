package by.dorosinec.traning.miniframework.Parsers;

import by.dorosinec.traning.miniframework.Instruction;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Class working with .json file
 */
public class WorkingJsonFile {
    JsonObject jsonObject;

    /**
     * Constructor of class. Create objects, which need to parse .json file
     *
     * @param filePath path to .json file
     */
    public WorkingJsonFile(String filePath) throws Exception {
        jsonObject = new JsonParser().parse(new BufferedReader(new FileReader(filePath))).getAsJsonObject();
    }

    /**
     * Method for get all instruction
     *
     * @param filePath path to .json file
     * @return list of instruction
     * @throws Exception if .json file not exist
     */
    public ArrayList<Instruction> getLine(String filePath) throws Exception {
        ArrayList<Instruction> paramInstruction = new ArrayList<>();
        JsonArray jsonElements = jsonObject.getAsJsonArray("instructions");
        for (JsonElement jsonElement : jsonElements) {
            paramInstruction.add(new Instruction().parseInstruction(getInstructionOfLine(jsonElement.getAsJsonObject())));
        }
        return paramInstruction;
    }

    /**
     * Method which receives all instructions arguments
     *
     * @param jsonObject JsonObject object
     * @return arrayList with all parameters of instruction
     */
    private ArrayList<String> getInstructionOfLine(JsonObject jsonObject) throws Exception {
        ArrayList<String> paramInstruction = new ArrayList<>();
        paramInstruction.add(jsonObject.get(Instruction.NAME_INSTRUCTION) == null
                ? null : jsonObject.get(Instruction.NAME_INSTRUCTION).getAsString());
        paramInstruction.add(jsonObject.get(Instruction.ARG1) == null
                ? null : jsonObject.get(Instruction.ARG1).getAsString());
        paramInstruction.add(jsonObject.get(Instruction.ARG2) == null
                ? null : jsonObject.get(Instruction.ARG2).getAsString());
        return paramInstruction;
    }
}
