package by.dorosinec.traning.htmlTable;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * This class contains methods for finding the name, type, date and the file size in the directory
 */
public class InformationDataDirectory {
    /**
     * Obtain the file name in the directory
     * @param elements element of directory
     * @return name element of directory
     */
    public String getNameContentsDirectory(File elements) {
        String nameElementOfDirectory = elements.getName();
        return nameElementOfDirectory;
    }

    /**
     * Obtain the file type in the directory
     * @param elements element of directory
     * @return type element of directory
     */
    public String getTypeContentsDirectory(File elements) {
        String type = "";
        if (elements.isDirectory()) {
            type = "DIR";
        }
        if (elements.isFile()) {
            type = "FILE";
        }
        return type;
    }

    /**
     * Obtain the file date in the directory
     * @param elements element of directory
     * @return date created element of directory
     * @OIException if errors with file existing
     */
    public String getDateContentsDirectory(File elements) throws IOException {

        Path file = elements.toPath();
        BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String dateCreated = df.format(attr.creationTime().toMillis());
        return dateCreated;
    }

    /**
     * Obtaining the size of files and folders
     * @param elements element of directory
     * @return size element of directory
     */
    public long getSizeFileDirectory(File elements) {
        if (elements.isFile()) {
            return elements.length();
        }
        if (elements.isDirectory()) {
            return getSizeDirectory(elements);
        }
        return 0;
    }

    /**
     * Recursive folder size calculation
     * @param elements element of directory
     * @return size folder of directory
     */
    public long getSizeDirectory(File elements) {
        long size = 0;
        File[] listContents = elements.listFiles();
        if (listContents != null) {
            for (File element: listContents) {
                if (element.isFile()) {
                    size += element.length();
                }
                if (element.isDirectory()) {
                    size += getSizeDirectory(element);
                }
            }
        }
        return size;
    }

    /**
     * Convert size byte to Kbyte
     * If size file less then 1024 byte, rounding up to 1 Kbyte
     * @param sizeFileDirectry size element directory
     * @return size element of directory in Kbyte
     */
    public long convertByteToKbyte(long sizeFileDirectry) {
        if (sizeFileDirectry == 0) {
            return 0;
        }
        if (sizeFileDirectry < 1024) {
            return 1;
        }
        return sizeFileDirectry / 1024;
    }
}
