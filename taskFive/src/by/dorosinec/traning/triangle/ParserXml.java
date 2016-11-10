package by.dorosinec.traning.triangle;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Class for read XML file
 */
public class ParserXml {
    /**
     * Parse XML file
     *
     * @param xmlFile file to parse
     * @return parsed document
     * @throws Exception if error occurred while processing
     */
    public Document getXml(String xmlFile) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        File testDataFile = new File(xmlFile);
        return documentBuilder.parse(testDataFile);
    }


}
