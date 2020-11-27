package utils;
import java.util.*;

public class InputValidator {
    private static final String INVALID_LENGTH_MSG = "잘못된 입력 길이입니다. ";
    private static final String INVALID_RANGE_MSG = "범위 외 입력입니다. ";
    private static final String INVALID_DUPLICATE_MSG = "중복이 포함된 입력입니다. ";

    private static final int MAX_NUM = 9;
    private static final int MIN_NUM = 1;

    private static final int BUTTON_PLAY_AGAIN_MAX = 2;
    private static final int BUTTON_PLAY_AGAIN_MIN = 1;

    private InputValidator(){}

    public static boolean isValidPlayAgainAns(String input) throws IllegalArgumentException {
        if(!isInRange(input, BUTTON_PLAY_AGAIN_MIN, BUTTON_PLAY_AGAIN_MAX)){
            throw new IllegalArgumentException(INVALID_RANGE_MSG);
        }
        return true;
    }

    public static boolean isValidGuess(String inputNumber, int len) throws IllegalArgumentException {
        if(!isValidLength(inputNumber, len)){
            throw new IllegalArgumentException(INVALID_LENGTH_MSG);
        }

        if(!isInRange(inputNumber, MIN_NUM, MAX_NUM)){
            throw new IllegalArgumentException(INVALID_RANGE_MSG);
        }

        if(!isAllDifferent(inputNumber)){
            throw new IllegalArgumentException(INVALID_DUPLICATE_MSG);
        }

        return true;
    }

    private static boolean isInRange(String input, int min, int max){
        if(!isNumericString(input)){
            return false;
        }

        return Arrays.stream(input.split("")).map(Integer::parseInt).allMatch(x-> x >= min && x <= max);
    }

    private static boolean isValidLength(String input, int len){
        return input.length() == len;
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
        return Arrays.stream(input.split("")).distinct().count() == input.length();
    }
}
