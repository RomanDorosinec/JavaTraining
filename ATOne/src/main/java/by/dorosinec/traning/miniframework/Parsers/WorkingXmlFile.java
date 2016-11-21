package by.dorosinec.traning.miniframework.Parsers;

import by.dorosinec.traning.miniframework.Instruction;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

/**
 * Class working with .xml file
 */
public class WorkingXmlFile {
    private final static String INSTRUCTIONS = "instructions";
    Document document;

    /**
     * Constructor of class. Create objects, which need to parse xml file
     *
     * @param filePath path to .xml file
     */
    public WorkingXmlFile(String filePath) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        document = documentBuilder.parse(new File(filePath));
    }

    /**
     * Method for get all instruction
     *
     * @return list of instruction
     * @throws Exception if .xml file not exist
     */
    public ArrayList<Instruction> getLine(String filePath) throws Exception {
        ArrayList<Instruction> linesOfFile = new ArrayList<>();
        NodeList nodes = document.getElementsByTagName(INSTRUCTIONS);
        for (int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap namedNodeMap = nodes.item(i).getAttributes();
            linesOfFile.add(new Instruction().parseInstruction(getInstructionOfLine(namedNodeMap)));
        }
        return linesOfFile;
    }

    /**
     * Method get all parameters of instruction
     *
     * @param namedNodeMap object
     * @return arrayList with all parameters of instruction
     */
    private ArrayList<String> getInstructionOfLine(NamedNodeMap namedNodeMap) throws Exception {
        ArrayList<String> paramInstruction = new ArrayList<>();
        paramInstruction.add(namedNodeMap.getNamedItem(Instruction.NAME_INSTRUCTION) == null
                ? null : namedNodeMap.getNamedItem(Instruction.NAME_INSTRUCTION).getNodeValue());
        paramInstruction.add(namedNodeMap.getNamedItem(Instruction.ARG1) == null
                ? null : namedNodeMap.getNamedItem(Instruction.ARG1).getNodeValue());
        paramInstruction.add(namedNodeMap.getNamedItem(Instruction.ARG2) == null
                ? null : namedNodeMap.getNamedItem(Instruction.ARG2).getNodeValue());
        return paramInstruction;
    }
}