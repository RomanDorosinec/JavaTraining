package by.dorosinec.traning.htmlTable;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Data html table
 */
public class HtmlTable {
    private final String TH_COLOR = "#C0C0C0";
    private final String BORDER_COLOR = "#FFFFFF";
    private final String LINE_ONE_COLOR = "#D3D3D3";
    private final String LINE_TWO_COLOR = "#DCDCDC";
    private final String FILE_HEAD = "<!DOCTYPE HTML>\n" +
            " <html>\n" +
            "  <head>\n" +
            "    <meta charset=\"utf-8\">\n" +
            "    <title>File of directory</title>\n" +
            "   <style type=\"text/css\">\n" +
            "    TABLE {\n" +
            "     border-collapse: collapse;\n" +
            "    }\n" +
            "    TD, TH {\n" +
            "     padding-left: 6px;\n" +
            "     padding-right: 6px;\n" +
            "     border: 3px solid " + BORDER_COLOR + ";\n" +
            "    }\n" +
            "   </style>\n" +
            "  </head>" +
            " <body>\n" +
            "   <table border=\"1\">\n";
    private final String TABLE_HEAD = " <thead bgcolor= " + TH_COLOR + " align=\"center\">\n" +
            "  <tr>\n" +
            "   <td width=\"150\">ИМЯ</td>\n" +
            "   <td width=\"150\">ТИП</td>\n" +
            "   <td width=\"150\">ДАТА СОЗДАНИЯ</td>\n" +
            "   <td width=\"150\">РАЗМЕР (в Kb)</td>\n" +
            "  </tr>\n" +
            " </thead>\n" +
            " <tbody>";
    private final String TABLE_FOOTER = "</tbody>\n" +
            "  </table>\n" +
            " </body>\n" +
            "</html>\n";
    //
    private ArrayList<String> rowTable= new ArrayList<>();
    /**
     * Filling lines html table and create this in the Array list
     * @param name name element of directory
     * @param type type element of directory
     * @param date data created element of directory
     * @param size size element of directory
     */
    public void fillingLinesHtmlTable(String name, String type, String date, long size) {
        int countColor = 1;
        String colorLine = "";
        if (countColor%2 != 0) {
            colorLine = LINE_ONE_COLOR;
        } else {
            colorLine = LINE_TWO_COLOR;
        }
        rowTable.add("<tr bgcolor=" + colorLine + ">\n" +
                "   <td>" + name + "</td>\n" +
                "   <td>" + type + "</td>\n" +
                "   <td>" + date + "</td>\n" +
                "   <td>" + size + "</td>\n" +
                "  </tr>\n");
        countColor++;
    }

    /**
     * Entry html table into a file
     * @param htmlFile where file write
     * @return html file with a table
     * @throws IOException if errors with file existing or reading\writing rights occurred
     */
    public BufferedWriter saveToFile(BufferedWriter htmlFile) throws IOException {
        htmlFile.write(FILE_HEAD + TABLE_HEAD);
        for (String row : rowTable) {
            htmlFile.write(row);
        }
        htmlFile.write(TABLE_FOOTER);
        htmlFile.close();
        return htmlFile;
    }
}
