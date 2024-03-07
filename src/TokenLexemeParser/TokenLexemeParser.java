package TokenLexemeParser;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


// This class is responsible for parsing the input file
// and tokenizing the content

public class TokenLexemeParser {

    public static ArrayList<String[]> lexicalAnalyzer(String content) {

        ArrayList<String[]> tokensLexemes = new ArrayList<>();

        // Regular expression to tokenize the input file
        // The regular expression is divided into 5 groups all in one line
        // 1. Keywords
        // 2. Separators
        // 3. Identifiers
        // 4. Real and Integer
        //   Real is a number with a decimal point
        //   Integer is a number without a decimal point
        // 5. String
        // Pattern is used to compile the regular expression
        // Matcher is used to match the regular expression with the content
        // Kind of like using 5 State FSA in one regular expression
        String tokens = "\\b(out|while|int|float|if|else|for|return|void|struct|class|public|static|catch|def|import" +
                        "|elif|System|err|println|String|double)\\b|" + // Keywords, there are many more depending on language
                "([;{}(),<>=.\\[\\]])|" + // Separators
                "([A-Za-z_][A-Za-z0-9_]*)|" + // Identifiers
                "(\\d+\\.\\d+|\\d+)|" + // Real and Integer
                "(\"[^\"]*\")"; // String

        Pattern pattern = Pattern.compile(tokens);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                tokensLexemes.add(new String[]{"Keyword", matcher.group()});
            } else if (matcher.group(2) != null) {
                tokensLexemes.add(new String[]{"Separator", matcher.group()});
            } else if (matcher.group(3) != null) {
                tokensLexemes.add(new String[]{"Identifier", matcher.group()});
            } else if (matcher.group(4) != null) {
                if (matcher.group().contains(".")) {
                    tokensLexemes.add(new String[]{"Real", matcher.group()});
                } else {
                    tokensLexemes.add(new String[]{"Integer", matcher.group()});
                }
            } else if (matcher.group(5) != null) {
                tokensLexemes.add(new String[]{"String", matcher.group()});
            }
        }
        return tokensLexemes;
    }

    // Removes inline comments
    public static String removeComments(String content) {
        return content.replaceAll("//.*", "");
    }
}
