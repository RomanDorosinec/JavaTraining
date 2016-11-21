package by.dorosinec.traning.miniframework;

import by.dorosinec.traning.miniframework.Parsers.WorkingCommandLine;
import by.dorosinec.traning.miniframework.Parsers.WorkingJsonFile;
import by.dorosinec.traning.miniframework.Parsers.WorkingTxtFile;
import by.dorosinec.traning.miniframework.Parsers.WorkingXmlFile;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for read data from files or command line
 */
public class Reader {

    public static final String TXT_FILE = "instruction.txt";
    public static final String XML_FILE = "instruction.xml";
    public static final String JSON_FILE = "instruction.json";

    /**
     * Methods chooses where to get the data
     *
     * @param args command line
     * @return arrayList with all parameters of instruction
     * @throws Exception if not input data or not file exist
     */
    public ArrayList<Instruction> getInstruction(String[] args) throws Exception {
        ArrayList<Instruction> lines = null;

        if (args.length != 0) {
            lines = new WorkingCommandLine().getLine(args);
        } else {
            System.out.println("Choose input: 1 - .txt file; 2 - .xml file; 3 - .json file;");
            int chooseFile = Integer.parseInt(new Scanner(System.in).next());
            switch (chooseFile) {
                case 1:
                    lines = new WorkingTxtFile().getLine(TXT_FILE);
                    break;
                case 2:
                    lines = new WorkingXmlFile(XML_FILE).getLine(XML_FILE);
                    break;
                case 3:
                    lines = new WorkingJsonFile(JSON_FILE).getLine(JSON_FILE);
                    break;
                default:
                    throw new Exception("");
            }
        }
        if (lines == null) {
            throw new Exception("Not input data!");
        }
        return lines;
    }
}
