package TokenLexemeParser;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


// This class is responsible for parsing the input file
// and tokenizing the content

public class TokenLexemeParser {

    public static ArrayList<String[]> lexAnalysis(String content) {

        ArrayList<String[]> tokens = new ArrayList<>();

        // Regular expression to tokenize the input file

        String regex = "\\b(while|int|float|if|else)\\b|([;{}(),<>=])|([A-Za-z_][A-Za-z0-9_]*)|(\\d+\\.\\d+|\\d+)|(\"[^\"]*\")";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                tokens.add(new String[]{"Keyword", matcher.group()});
            } else if (matcher.group(2) != null) {
                tokens.add(new String[]{"Separator", matcher.group()});
            } else if (matcher.group(3) != null) {
                tokens.add(new String[]{"Identifier", matcher.group()});
            } else if (matcher.group(4) != null) {
                if (matcher.group().contains(".")) {
                    tokens.add(new String[]{"Real", matcher.group()});
                } else {
                    tokens.add(new String[]{"Integer", matcher.group()});
                }
            } else if (matcher.group(5) != null) {
                tokens.add(new String[]{"String", matcher.group()});
            }
        }
        return tokens;
    }

    // Removes inline comments
    public static String removeComments(String content) {
        return content.replaceAll("//.*", "");
    }
}
