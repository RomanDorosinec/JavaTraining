package by.dorosinec.traning.ipAdress;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;

/**
 * Data html table
 */
public class HtmlTable {
    private final String TH_COLOR = "#C0C0C0";
    private final String COLOR_MAX_PING = "#F71B1B";
    private final String COLOR_COMMON_PING = "#EFEFEF";
    private final String BORDER_COLOR = "#FFFFFF";
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
            "   <td width=\"250\">Server</td>\n" +
            "   <td width=\"250\">Response, ms</td>\n" +
            "  </tr>\n" +
            " </thead>\n" +
            " <tbody>";
    private final String TABLE_FOOTER = "</tbody>\n" +
            "  </table>\n" +
            " </body>\n" +
            "</html>\n";

    /**
     * Filling lines html table and create this in the Array list
     * @param dataToExport data write to html
     * @return line html table
     * @throws Exception
     */
    private String fillingLinesHtmlTable(DataToExport dataToExport) throws Exception {
        return "<tr>" +
                "   <td bgcolor=\"" + (dataToExport.getColor() ? COLOR_MAX_PING : COLOR_COMMON_PING) + "\">" + dataToExport.getIp() + "</td>\n" +
                "   <td bgcolor=\"" + (dataToExport.getColor() ? COLOR_MAX_PING : COLOR_COMMON_PING) + "\">" + dataToExport.getPing() + "</td>\n" +
                "  </tr>\n";
    }

    /**
     * Entry html table into a file
     * @param htmlFile htmlFile where file write
     * @param dataToExport list data about servers
     * @return file with a table
     * @throws Exception
     */
    public BufferedWriter saveToFile(File htmlFile, ArrayList<DataToExport> dataToExport) throws Exception {
        BufferedWriter outputFile = new BufferedWriter(new FileWriter(htmlFile));
        outputFile.write(FILE_HEAD + TABLE_HEAD);
        for (DataToExport row : dataToExport) {
            outputFile.write(fillingLinesHtmlTable(row));
        }
        outputFile.write(TABLE_FOOTER);
        outputFile.close();
        return outputFile;
    }
}
