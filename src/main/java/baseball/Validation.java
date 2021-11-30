package baseball;

import constant.SystemMessage;

import java.util.stream.IntStream;

public class Validation {

    public static void inputCheck(String inputString) {
        lengthCheck(inputString);
        isValidNumberInput(inputString);
    };

    public static boolean lengthCheck(String inputString){
        if(inputString.length()!=SystemMessage.COMPARE_LENGTH){
            throw new IllegalArgumentException(SystemMessage.INPUT_LENGTH_ERROR);
        }
        return true;
    }

    public static void isValidNumberInput(String inputString){
        IntStream
            .range(0,SystemMessage.COMPARE_LENGTH)
            .forEach(index -> {
                isNotNumber(inputString.charAt((index)));
                isZero(inputString.charAt((index)));
            });
        return;
    }

    public static void isZero(char inputChar){
        if(inputChar=='0'){
            throw new IllegalArgumentException(SystemMessage.INPUT_ZERO_ERROR);
        }
    }

    public static void isNotNumber(char inputChar){
        if(!Character.isDigit(inputChar)){
            throw new IllegalArgumentException(SystemMessage.INPUT_NUMERIC_ERROR);
        }
    }
}
