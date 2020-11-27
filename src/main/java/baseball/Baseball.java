package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Baseball {
    private ArrayList<Integer> baseball = new ArrayList<>();

    public boolean parseBaseball(String userInput){
        if(validateInput(userInput)){
            baseball.clear();
            for(char ball : userInput.toCharArray()){
                baseball.add(Character.getNumericValue(ball));
            }
            return true;
        }
        return false;
    }

    public boolean validateInput(String userInput){
        try{
            validateDuplicate(userInput);
            validateDigits(userInput);
            validateLength(userInput);
        }
        catch(IllegalArgumentException errorMessage){
            System.out.println(errorMessage);
            System.out.println(Constants.PROMPT_MESSAGE_AGAIN);
            return false;
        }
        return true;
    }

    public void validateLength(String baseball){
        if(baseball.length() != Constants.VALID_INPUT_LENGTH){
            throw new IllegalArgumentException(Constants.ERR_MSG_VALID_LENGTH);
        }
    }

    public void validateDuplicate(String baseball){
        Set<Character> duplicateCheck = new HashSet<>();
        for(char ball : baseball.toCharArray()){
            if(duplicateCheck.contains(ball)){
                throw new IllegalArgumentException(Constants.ERR_MSG_DUPLICATE_DIGITS);
            }
            duplicateCheck.add(ball);
        }
    }

    public void validateDigits(String baseball){
        for(char ball : baseball.toCharArray()){
            if(!(Constants.MIN_VALID_INPUT_DIGIT<=ball &&
                    ball <= Constants.MAX_VALID_INPUT_DIGIT)){
                throw new IllegalArgumentException(Constants.ERR_MSG_VALID_DIGITS);
            }
        }
    }

    public ArrayList<Integer> getBaseballs(){
        return baseball;
    }
}
