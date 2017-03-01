package projectpackage.support;

import projectpackage.support.matchers.StringMatcher;

/**
 * Created by Lenovo on 01.03.2017.
 */
public class StringTool {
    public static StringMatcher getMatcher(String regex){
        return new StringMatcher(regex);
    }
}
