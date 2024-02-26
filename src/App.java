import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
public class App {
    public static void main(String[] args) {

        // Declaring input and output file names and where they are located
        final String inputFileName = "inputFile/input_scode.txt";
        final String outputFileName = "outputFile/output_scode.txt";
        
        // try catch block to catch any exceptions for calling the parse function
        // parse function will read the input file and write the output file
        // and call the function to parse
        try {
            parse(inputFileName, outputFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // parse function 
    // parameters: inputFileName, outputFileName
    // return: void
    // function: read the input file and write the output file
    // and call the function to parse the input file LINE by LINE
    // for now instead of writing to a file, it will print to the console
    // the tokens are stored in an arraylist
    // TODO: go through the arraylist and find the lexemes
    // TODO: deal with multiline comments in code file

    public static void parse(String inputFileName, String outputFileName) throws Exception{
     
        Scanner fileInput = new Scanner(new FileReader(inputFileName));
        PrintWriter fileOutput = new PrintWriter(outputFileName);
        
        while (fileInput.hasNextLine()) {
            String line = fileInput.nextLine();

            ArrayList<String> tokenList = tokenize(line);

            // TOTO: go through the arraylist and find the lexemes

            for (String token : tokenList) {
                System.out.println(token);
            }
        }

        fileInput.close();
        fileOutput.close();

    }

    // tokenize function
    // TODO: implement the function to tokenize the input file
    
    public static ArrayList<String> tokenize(String input) {

        // maybe add more states
        enum State {
            Normal, InComment, InLineComment, InString, InOperator
        }

        State state = State.Normal;

        ArrayList<String> tokenList = new ArrayList<>();
        











    
        return tokenList;
    }
}
