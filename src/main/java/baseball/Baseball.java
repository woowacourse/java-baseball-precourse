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
        if(validateDuplicate(userInput) &&
                validDigits(userInput) &&
                validateLength(userInput)){
            return true;
        }
        return false;
    }

    public boolean validateLength(String baseball){
        try{
            if(baseball.length() != Constants.VALID_INPUT_LENGTH){
                throw new IllegalArgumentException(Constants.ERR_MSG_VALID_LENGTH);
            }
        }
        catch(IllegalArgumentException errorMessage){
            System.out.println(errorMessage);
            return false;
        }
        return true;
    }

    public boolean validateDuplicate(String baseball){
        try{
            HashMap<Character, Integer> duplicateMap = new HashMap<>();
            for(char ball : baseball.toCharArray()){
                if(duplicateMap.get(ball) != null){
                    throw new IllegalArgumentException(Constants.ERR_MSG_DUPLICATE_DIGITS);
                }
                duplicateMap.put(ball, 1);
            }
        }
        catch(IllegalArgumentException errorMessage){
            System.out.println(errorMessage);
            return false;
        }
        return true;
    }

    public boolean validDigits(String baseball){
        try{
            for(char ball : baseball.toCharArray()){
                if(!(Constants.MIN_VALID_INPUT_DIGIT<=ball &&
                        ball <= Constants.MAX_VALID_INPUT_DIGIT)){
                    throw new IllegalArgumentException(Constants.ERR_MSG_VALID_DIGITS);
                }
            }
        }
        catch(IllegalArgumentException errorMessage){
            System.out.println(errorMessage);
            return false;
        }
        return true;
    }

    public ArrayList<Integer> getBaseballs(){
        return baseball;
    }
}
