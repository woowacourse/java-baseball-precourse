package baseball;

import constant.SystemMessage;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Validation {

    public static void inputCheck(String inputString) {
        lengthCheck(inputString);
        isValidNumberInput(inputString);
        isUniqueNumber(inputString);
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

    public static int isContinueInputValid(String inputNumber){
        if(inputNumber.equals("1")){
            return SystemMessage.RESTART_CODE;
        }
        if(inputNumber.equals("2")) {
            return SystemMessage.EXIT_CODE;
        }
        throw new IllegalArgumentException(SystemMessage.CONTINUE_INPUT_ERROR);
    };

    public static void isUniqueNumber(String inputString){
        Set<String> numberSet = new HashSet<String>();
        String[] inputArray = inputString.split("");
        for(String elem: inputArray){
            if(numberSet.contains(elem)){
                throw new IllegalArgumentException(SystemMessage.INPUT_NOT_UNIQUE);
            }
        }
        return;
    }
}
