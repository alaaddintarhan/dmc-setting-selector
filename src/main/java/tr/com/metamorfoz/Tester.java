package tr.com.metamorfoz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tester {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^[0-9][0-9]*$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("654987");
        boolean matchFound = matcher.find();
        if(matchFound) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }
    }
}
