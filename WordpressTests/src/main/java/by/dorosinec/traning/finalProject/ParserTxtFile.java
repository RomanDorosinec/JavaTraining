package by.dorosinec.traning.finalProject;

import by.dorosinec.traning.finalProject.addUsers.Users;

import java.io.*;
import java.util.ArrayList;

/**
 * Parser of .txt file
 * This is a file from the login password and user data
 */
public class ParserTxtFile {
    private static final String FILE_PATH = "login_password.txt";

    /**
     * Getting all line from a file
     *
     * @return list of all user with their data
     */
    private ArrayList<String> getLineOfFile() {
        BufferedReader reader;
        ArrayList<String> allLineOfFile = new ArrayList<String>();
        try {
            reader = new BufferedReader(new FileReader(new File(FILE_PATH)));
            String nextLine = reader.readLine();
            while (nextLine != null) {
                allLineOfFile.add(nextLine);
                nextLine = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Nothing to read from a file");
        }
        return allLineOfFile;
    }

    /**
     * Parses the line from file
     *
     * @return object of users with all the information about him
     */
    public ArrayList<Users> allParametersUser() {
        ArrayList<Users> users = new ArrayList<Users>();
        ArrayList<String> allLineOfFile = getLineOfFile();
        for (String s : allLineOfFile) {
            String[] parameters = s.split(" ");
            users.add(new Users(parameters[0], parameters[1], parameters[2], parameters[3], parameters[4]));
        }
        return users;
    }
}
