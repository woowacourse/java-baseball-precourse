package baseball;

import java.util.regex.Pattern;

public class UserInputValidator {
    public static String check(String userInput) {
        String pattern = "^[1-9]{3}";
        boolean regex = Pattern.matches(pattern, userInput);

        if (!regex) {
            throw new IllegalArgumentException(Constants.INPUT_ERROR_MSG);
        }
        return userInput;
    }
}
