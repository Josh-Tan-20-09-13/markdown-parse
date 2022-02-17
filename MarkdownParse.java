// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String[] markdown) {
    ArrayList<String> toReturn = new ArrayList<>();
    // find the next [, then find the ], then find the (, then take up to
    // the next )

    // iterate through lines in file
    for (int i = 0; i < markdown.length; i++) {
        String line = markdown[i];

        boolean ended = false;
        
        boolean started = false;

        String retString = "";

        for (char c : line.toCharArray()) {
            int badBChars = 0;
            int badPChars = 0;

            if (c == ')' && started && badBChars > 0) {
                badBChars -= 1;
            } else if (c == ')' && started) {
                started = false;
                if (!retString.equals("")) {
                    ArrayList<String> possibleLinks = new ArrayList<String>();
                        for (String j : retString.split("\\(")) {
                            String j = retString;
                            Pattern pattern = Pattern.compile("[^a-zA-Z0-9.&:/%=\\-_?;@+,]", Pattern.CASE_INSENSITIVE);

                            if (j != null && !pattern.matcher(j).find()) {
                                
                                Pattern link = Pattern.compile("(?<![\\!\\[\\]])\\[.*\\]\\([[:space:]]*" + Pattern.quote(j) + "[[:space:]]*\\)", Pattern.CASE_INSENSITIVE);
                                if (link.matcher(line).find()) {
                                    toReturn.add(j);
                                }

                            }

                        }


                }
                retString = "";
            }

            if (started) {
                retString += c;
            }

            if (c == '(' && !started) {
                started = true;
            } else if (c == '(' && started) {
                badBChars += 1;
            }
        }

    }
    return toReturn;
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents.split("\n"));
        System.out.println(links);
    }
}
