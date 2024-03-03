import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;

import java.util.Scanner;
import java.util.ArrayList;
public class App {

    public static void main(String[] args) {
        // Declaring input and output file names and where they are located
        final String inputFileName = "./inputFile/input_scode.txt";
        final String outputFileName = "./outputFile/output_scode.txt";

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
    // the tokens are stored in a hashmap
    // TODO: go through the hashmap and find the lexemes
    // TODO: deal with multiline comments in code file
    public static void parse(String inputFileName, String outputFileName) throws Exception {

        Scanner fileInput = new Scanner(new FileReader(inputFileName));
        PrintWriter fileOutput = new PrintWriter(outputFileName);

        while (fileInput.hasNextLine()) {
            String line = fileInput.nextLine();

            // initialize a hashmap of strings to store the tokens

            HashMap < String, String > lexemeToken = tokenLexemeParser(line);

            // TODO: go through the hashmap and find the lexemes
            for (String lexeme: lexemeToken.keySet()) {
                fileOutput.print("lexeme: " + lexeme + ", token: " + lexemeToken.get(lexeme));
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

    public static HashMap < String, String > tokenLexemeParser(String input) {
        final ArrayList < String > OPERATORS = new ArrayList < String > (Arrays.asList(
            "+", "-", "*", "/", "%", // Arithmetic Operators
            "<", ">", "<=", ">=", "==", "!=", // Relational Operators
            "&&", "||", "!", // Logical Operators
            "&", "|", "^", "~", "<<", ">>", // Bitwise Operators
            "=", "+=", "-=", "*=", "/=", "%=", "&=", "|=", "^=", "<<=", ">>=", // Assignment Operators
            "?:", "->", "::", "." // Miscellaneous Operators
        ));

        final ArrayList < String > SYMBOLS = new ArrayList < String > (Arrays.asList(
            "{", "}", "(", ")", "[", "]", ";", ",", ".", // Common delimiters and separators
            "\"", "'", "#", // String literals, character literals, and preprocessor directive (in some languages)
            "@", "`", ":", // Annotations, backticks, and the colon symbol
            "\\", // Escape character
            "$" // Variable identifier in some scripting languages
        ));

        final ArrayList < String > KEYWORDS = new ArrayList < String > (Arrays.asList(
            "abstract", "assert", "boolean", "break", "byte",
            "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else",
            "enum", "extends", "final", "finally", "float",
            "for", "goto", "if", "implements", "import",
            "instanceof", "int", "interface", "long", "native",
            "new", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super",
            "switch", "synchronized", "this", "throw", "throws",
            "transient", "try", "void", "volatile", "while"
        ));
        final ArrayList < String > NUMBERS = new ArrayList < String > (Arrays.asList(
            "1", "2", "3", "4", "5", "6", "7", "8", "9"
        ));

        // I am trying to implement a Finite State Machine (FSM) to parse the input string
        // TODO: maybe another approach is better???
        // maybe add more states

        HashMap < String, String > lexemeToken = new HashMap < String, String > ();
        String lexeme = "";
        String token = "";

        // for loop to loop through every character in the input string
        // c is the current character and nextChar is the next character
        // if the nextChar is the last character in the string, it will be null
        int left = 0;
        int right = 0;
        int len = input.length();

        while (right < len && left <= right) {
            char currentChar = input.charAt(right);

            // Finite State Machine (FSM) to parse the input string
            // TODO: implement the normal state

            if (OPERATORS.contains(currentChar)) {
                right++;
            }
            if (SYMBOLS.contains(currentChar)) {
                right++;
            }
            if (NUMBERS.contains(currentChar)) {
                right++;
            }
            //need to keep moving right forward until there is a space and then 
            //check the substring from left index to right index
            String subString = input.substring(left, right).toLowerCase();
            if (KEYWORDS.contains(subString)) {
                lexemeToken.put(subString, "keyword");
                right++;
                left = right;
            }
            right++;
        }
        return lexemeToken;
    }

}