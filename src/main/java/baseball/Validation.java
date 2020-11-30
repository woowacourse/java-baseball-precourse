package baseball;

import java.util.HashMap;

public class Validation {
    public static boolean validateInput(String userInput){
        try{
            validateDuplicate(userInput);
            validateDigits(userInput);
            validateLength(userInput);
        }
        catch(IllegalArgumentException errorMessage){
            System.err.println(errorMessage);
            System.out.println(Constants.PROMPT_MESSAGE_AGAIN);
            return false;
        }
        return true;
    }

    private static void validateLength(String baseball){
        if(baseball.length() != Constants.VALID_INPUT_LENGTH){
            throw new IllegalArgumentException(Constants.ERR_MSG_VALID_LENGTH);
        }
    }

    private static void validateDuplicate(String baseball){
        HashMap<Character, Integer> duplicateMap = new HashMap<>();
        for(char ball : baseball.toCharArray()){
            if(duplicateMap.get(ball) != null){
                throw new IllegalArgumentException(Constants.ERR_MSG_DUPLICATE_DIGITS);
            }
            duplicateMap.put(ball, 1);
        }
    }

    private static void validateDigits(String baseball){
        for(char ball : baseball.toCharArray()){
            if(!(Constants.MIN_VALID_INPUT_DIGIT<=ball &&
                    ball <= Constants.MAX_VALID_INPUT_DIGIT)){
                throw new IllegalArgumentException(Constants.ERR_MSG_VALID_DIGITS);
            }
        }
    }
}
