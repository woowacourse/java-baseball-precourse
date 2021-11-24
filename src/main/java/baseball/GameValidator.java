package baseball;


import java.util.HashSet;
import java.util.Set;

import static util.GameConstant.*;

class GameValidator {

    public static boolean isValidInput(String input){
        return isNumber(input) && isRightLength(input)
                && isNotDuplicate(input) && isRangeBetweenOneToTen(input);
    }

    private static boolean isNumber(String input){
        for(int i = 0 ; i < NUMBER_LENGTH; i++){
            char digit = input.charAt(i);
            if(!Character.isDigit(digit)){
                return false;
            }
        }
        return true;
    }

    private static boolean isRightLength(String input){
        return input.length() == NUMBER_LENGTH;
    }

    private static boolean isNotDuplicate(String input){
        Set<Character> tempSet = new HashSet<>();
        for(int i = 0 ; i < NUMBER_LENGTH; i++){
            tempSet.add(input.charAt(i));
        }
        if(tempSet.size() == NUMBER_LENGTH){
            return true;
        }
        return false;
    }

    private static boolean isRangeBetweenOneToTen(String input){
        for(int i = 0 ; i < NUMBER_LENGTH; i++){
            int digit = Character.getNumericValue(input.charAt(i));

            if(digit < MIN_NUMBER || digit > MAX_NUMBER){
                return false;
            }
        }
        return true;
    }
}
