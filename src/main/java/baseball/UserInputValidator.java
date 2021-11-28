package baseball;

import java.util.regex.Pattern;

public class UserInputValidator {

    public static String playGameInput(String userInput) {
        String replacedUserInput = userInput.replace("\n", "");
        String pattern = "^[1-9]*$";
        boolean regex = Pattern.matches(pattern, replacedUserInput);
        
        if (!regex || replacedUserInput.length() != Constants.ANSWER_LENGTH ) {
            throw new IllegalArgumentException("[playGame]" + Constants.INPUT_ERROR_MSG);
        }
        return replacedUserInput;
    }
    
    public static String restartOrExitInput(String userInput) {
        String replacedUserInput = userInput.replace("\n", "");
        String pattern = "^[1-9]*$";
        boolean regex = Pattern.matches(pattern, replacedUserInput);
        
        if (!regex || replacedUserInput.length() != Constants.EXIT_OR_CONTINUE_LENGTH) {
            throw new IllegalArgumentException("[restartOrExit]" + Constants.INPUT_ERROR_MSG);
        }
        
        return replacedUserInput;
    }
}
