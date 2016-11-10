package by.dorosinec.traning.triangle;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import java.math.BigDecimal;

import static org.testng.Assert.*;

/**
 * Test class Triangle
 */
public class TriangleTest {
    private final String XML_FILE = "test.xml";
    private final String INVALID_PARAMS = "invalidParam";
    private final String VALID_PARAMS = "validTriangle";
    private final String SIDE_A = "side_A";
    private final String SIDE_B = "side_B";
    private final String SIDE_C = "side_C";
    private final String EXPECTED = "expected";

    ParserXml parserXml;

    @BeforeMethod
    public void beforeTest() {
        parserXml = new ParserXml();
    }

    @DataProvider(name = "Valid params of sides")
    public Object[][] validParams() throws Exception {
        Document document = parserXml.getXml(XML_FILE);
        NodeList nodeListValidParams = document.getElementsByTagName(VALID_PARAMS);
        Object[][] result = new Object[nodeListValidParams.getLength()][];
        int e = nodeListValidParams.getLength();
        for (int i = 0; i < nodeListValidParams.getLength(); i++) {
            NamedNodeMap nodeMap = nodeListValidParams.item(i).getAttributes();
            result[i] = new Object[]{
                    nodeMap.getNamedItem(EXPECTED).getNodeValue(),
                    new BigDecimal(nodeMap.getNamedItem(SIDE_A).getNodeValue()),
                    new BigDecimal(nodeMap.getNamedItem(SIDE_B).getNodeValue()),
                    new BigDecimal(nodeMap.getNamedItem(SIDE_C).getNodeValue()),
            };
        }
        return result;
    }

    @Test(dataProvider = "Valid params of sides")
    public void getTriangleTypeValidParam(String expected, BigDecimal sideA, BigDecimal sideB, BigDecimal sideC) throws Exception {
        assertEquals(new Triangle(sideA, sideB, sideC).getTriangleType(), expected);
    }

    @DataProvider(name = "Invalid params of sides")
    public Object[][] invalidParams() throws Exception {
        Document document = parserXml.getXml(XML_FILE);
        NodeList nodeListInvalidParams = document.getElementsByTagName(INVALID_PARAMS);
        Object[][] result = new BigDecimal[nodeListInvalidParams.getLength()][];
        for (int i = 0; i < nodeListInvalidParams.getLength(); i++) {
            NamedNodeMap nodeMap = nodeListInvalidParams.item(i).getAttributes();
            result[i] = new BigDecimal[]{
                    nodeMap.getNamedItem(SIDE_A) == null ? null : new BigDecimal(nodeMap.getNamedItem(SIDE_A).getNodeValue()),
                    nodeMap.getNamedItem(SIDE_B) == null ? null : new BigDecimal(nodeMap.getNamedItem(SIDE_B).getNodeValue()),
                    nodeMap.getNamedItem(SIDE_C) == null ? null : new BigDecimal(nodeMap.getNamedItem(SIDE_C).getNodeValue()),
            };
        }
        return result;
    }

    @Test(dataProvider = "Invalid params of sides", expectedExceptions = Exception.class)
    public void getTriangleTypeException(BigDecimal sideA, BigDecimal sideB, BigDecimal sideC) throws Exception {
        new Triangle(sideA, sideB, sideC).getTriangleType();
    }
}