import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
public class App {
    public static void main(String[] args) {

        // Declaring input and output file names and where they are located
        final String inputFileName = "src/inputFile/input_scode.txt";
        final String outputFileName = "src/outputFile/output_scode.txt";
        
        // try catch block to catch any exceptions for calling the parse function
        // parse function will read the input file and write the output file
        // and call the function to parse
        try {
            parse(inputFileName, outputFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // PARSE FUNCTION
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

            // initialize an arralist of arrays to store the tokens

            ArrayList<String[]> lexemeToken = tokenLexemeParser(line);

            // TOTO: go through the arraylist and find the lexemes

            for (String[] lexemeTokenPair : lexemeToken) {
                System.out.println(lexemeTokenPair[0] + " " + lexemeTokenPair[1]);
            }
        }

        fileInput.close();
        fileOutput.close();

    }

    // TOKEN LEXEME PARSER FUNCTION
    // parameters: input
    // return: ArrayList<String[]>
    // Return arrayList: [lexeme, token]
    // TODO: implement the function to tokenize the input file
    
    public static ArrayList<String[]> tokenLexemeParser(String input) {

        // maybe add more states
        enum State {
            Normal, Keyword, Symbol, Identifier, Integer, Operator, String, Constants
        }

        State state = State.Normal;

        ArrayList<String[]> lexemeToken = new ArrayList<String[]>();
        String lexeme = "";
        String token = "";

        // for loop to loop through every character in the input string
        // c is the current character and nextChar is the next character
        // if the nextChar is the last character in the string, it will be null
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            char nextChar = (i + 1 < input.length()) ? input.charAt(i + 1) : '\0';

            // Finite State Machine (FSM) to parse the input string
            switch (state) {
                case Normal:
                    // TODO: implement the normal state
                    break;
                case Keyword:
                    // TODO: implement the keyword state
                    break;
                case Symbol:
                    // TODO: implement the symbol state
                    break;
                case Identifier:
                    // TODO: implement the identifier state
                    break;
                case Integer:
                    // TODO: implement the integer state
                    break;
                case Operator:
                    // TODO: implement the operator state
                    break;
                case String:
                    // TODO: implement the string state
                    break;
                case Constants:
                    // TODO: implement the constants state
                    break;
            }

        }

        return lexemeToken;
    }
}
