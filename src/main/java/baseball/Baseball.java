package baseball;

import java.util.ArrayList;
import java.util.HashMap;

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
        HashMap<Character, Integer> duplicateMap = new HashMap<>();
        for(char ball : baseball.toCharArray()){
            if(duplicateMap.get(ball) != null){
                throw new IllegalArgumentException(Constants.ERR_MSG_DUPLICATE_DIGITS);
            }
            duplicateMap.put(ball, 1);
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
