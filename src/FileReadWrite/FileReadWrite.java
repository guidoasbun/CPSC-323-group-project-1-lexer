package FileReadWrite;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReadWrite {

    // File that reads the content of a file
    // and returns the content as a string
    // if the file is not found, it will return null
    public static String readFile(String filename) {
        String content = "";
        try (FileReader fileInput = new FileReader(filename);
             Scanner scanner = new Scanner(fileInput)) {
            while (scanner.hasNextLine()) {
                content += scanner.nextLine() + "\n";
            }
        } catch (IOException error) {
            System.err.println("Error reading file: " + error.getMessage());
            return null;
        }
        return content;
    }

    // File that writes the tokens to a file
    public static void writeFile(String filename, ArrayList<String[]> tokens) {
        try (PrintWriter fileOutput = new PrintWriter(new FileWriter(filename))) {
            fileOutput.println("Token              Lexeme");
            fileOutput.println("---------------------------------");
            for (String[] token : tokens) {
                fileOutput.printf("%-16s %s%n", token[0], token[1]);
            }
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

}

