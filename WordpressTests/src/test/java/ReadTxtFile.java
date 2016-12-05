import java.io.*;
import java.util.ArrayList;

public class ReadTxtFile {
    private static final String FILE_PATH = "C:\\Users\\Dorosinec\\IdeaProjects\\WordpressTests\\login_password.txt";

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

    public ArrayList<User> allParametersUser() {
        ArrayList<User> users = new ArrayList<User>();
        ArrayList<String> allLineOfFile = getLineOfFile();
        for (String s : allLineOfFile) {
            String[] parameters = s.split(" ");
            users.add(new User(parameters[0], parameters[1], parameters[2]));
        }
        return users;
    }
}