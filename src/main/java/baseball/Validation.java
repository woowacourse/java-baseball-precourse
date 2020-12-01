package baseball;

import static baseball.Constant.GAME_LENGTH;
import static baseball.Constant.MAX_LENGTH;

public class Validation {
    //
    public static boolean validateInputNumber(String inputNumber){
        if (!isNumeric(inputNumber) ||
                !compareBaseballLength(inputNumber) ||
                !isReduplication(inputNumber)){
            return false;
        }
        return true;
    }

    public static boolean validateContinueGameNumber(String continueGameNumber){
        if (!isNumeric(continueGameNumber) ||
            !compareGameLength(continueGameNumber)){
            return false;
        }
        return true;
    }

    public static boolean isNumeric(String inputNumber){
        return inputNumber.chars().allMatch(Character::isDigit);
    }

    public static boolean compareBaseballLength(String inputNumber){
        return inputNumber.length() == MAX_LENGTH;
    }

    public static boolean compareGameLength(String continueGameNumber){
        return continueGameNumber.length() == GAME_LENGTH;
    }


    public static boolean isReduplication(String inputNumber){

        return true;
    }

}
