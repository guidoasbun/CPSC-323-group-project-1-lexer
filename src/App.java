// CPSC 323-06 19665
// Project 1 - Lexical Analyzer
// Team Members:
// 1. Guido Asbun
// 2. Cade Duncan
// 3. Briyana Verdugo

import FileReadWrite.FileReadWrite;
import TokenLexemeParser.TokenLexemeParser;

import java.util.ArrayList;
public class App {
    public static void main(String[] args) {

        // Declaring input and output file names and where they are located
        // might have to change the file path to the correct location depending on the IDE used
        final String inputFileName = "src/inputOutputFiles/input_scode.txt";
        final String outputFileName = "src/inputOutputFiles/output_scode.txt";

        // content is the content of the input file in string format
        String content = FileReadWrite.readFile(inputFileName);

        // if the content is not null,
        // remove the comments and tokenize the content
        // then write the tokens to the output file
        if (content != null) {
            content = TokenLexemeParser.removeComments(content);
            ArrayList<String[]> tokens = TokenLexemeParser.lexAnalysis(content);
            FileReadWrite.writeFile(outputFileName, tokens);
        }
    }
}