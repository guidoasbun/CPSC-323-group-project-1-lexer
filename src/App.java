import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        String inputFileName = "inputFile/input_scode.txt";
        String outputFileName = "outputFile/output_scode.txt";

        Scanner fileInput = new Scanner(new FileReader(inputFileName));
        PrintWriter fileOutput = new PrintWriter(outputFileName);

        while (fileInput.hasNextLine()) {
            String line = fileInput.nextLine();
            fileOutput.println(line);
        }
        
        fileInput.close();
        fileOutput.close();
    }
}
