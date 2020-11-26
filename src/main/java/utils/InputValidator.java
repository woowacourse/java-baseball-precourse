package utils;
import java.util.*;

public class InputValidator {
    private static final String INVALID_LENGTH_MSG = "잘못된 입력 길이입니다.";
    private static final String INVALID_RANGE_MSG = "범위 외 입력입니다.";
    private static final String INVALID_DUPLICATE_MSG = "중복이 포함된 입력입니다.";

    private static final int BUTTON_PLAY_AGAIN_MAX = 2;
    private static final int BUTTON_PLAY_AGAIN_MIN = 1;

    private InputValidator(){}

    public static boolean validPlayAgainAnswer(String input) throws Exception{
        if(!isInRange(input, BUTTON_PLAY_AGAIN_MIN, BUTTON_PLAY_AGAIN_MAX)){
            throw new InvalidInputHandler(INVALID_RANGE_MSG);
        }
        return true;
    }

    private static boolean isInRange(String input, int min, int max){
        if(!isNumericString(input)){
            return false;
        }

        for(char num : input.toCharArray()){
            if(Character.getNumericValue(num)<min || Character.getNumericValue(num)>max){
                return false;
            }
        }
        return true;
    }

    public static boolean validGuessNumber(String inputNumber, int len) throws Exception{
        if(!isValidLength(inputNumber, len)){
            throw new InvalidInputHandler(INVALID_LENGTH_MSG);
        }

        if(!isNumericString(inputNumber)){
            throw new InvalidInputHandler(INVALID_RANGE_MSG);
        }

        if(!isAllDifferent(inputNumber)){
            throw new InvalidInputHandler(INVALID_DUPLICATE_MSG);
        }

        return true;
    }

    private static boolean isValidLength(String input, int len){
        if(input.length() == len){
            return true;
        }
        return false;
    }

    private static boolean isNumericString(String input){
        try{
            Integer.parseInt(input);
        }catch (IllegalArgumentException IAE){
            return false;
        }
        return true;
    }

    private static boolean isAllDifferent(String input){
        char[] chars = input.toCharArray();
        Arrays.sort(chars);

        for(int i =0; i<chars.length-1; i++){
            if(chars[i] == chars[i+1]){
                return false;
            }
        }
        return true;
    }
}
