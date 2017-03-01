package projectpackage.support.matchers;

/**
 * Created by Lenovo on 01.03.2017.
 */
public class StringMatcher {
    private String regex;

     public StringMatcher(String regex) {
        this.regex = regex;
    }

    public boolean match(String stringToMatch){
        return stringToMatch.matches(regex);
    }
}
