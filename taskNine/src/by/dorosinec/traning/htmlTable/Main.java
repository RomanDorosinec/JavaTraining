package by.dorosinec.traning.htmlTable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * This class is an entry point in the program
 */
public class Main {
    /**
     * Entry point in the program.
     * @param args command line argument
     */
    public static void main(String[] args) {
        File ourDirectory = new File(System.getProperty("user.dir"));
        HtmlTable htmlTable = new HtmlTable();
        InformationDataDirectory informationDataDirectory = new InformationDataDirectory();
        File[] listOfContents = ourDirectory.listFiles();
        try {
            BufferedWriter htmlFile = new BufferedWriter(new FileWriter("directory.html"));
            for (File elements : listOfContents) {
                htmlTable. fillingLinesHtmlTable(informationDataDirectory.getNameContentsDirectory(elements),
                                                 informationDataDirectory.getTypeContentsDirectory(elements),
                                                 informationDataDirectory.getDateContentsDirectory(elements),
                                                 informationDataDirectory.convertByteToKbyte(informationDataDirectory.getSizeFileDirectory(elements)));
            }
            htmlTable.saveToFile(htmlFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
