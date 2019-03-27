package baseball;

import java.util.regex.Pattern;

public class BaseballNumber {
    private static final String numberPattern = "^([1-9]{3})$";

    public static boolean checkValidNumber(String inputNumber) {
        if (checkInputInRange(inputNumber) && checkInputDuplicate(inputNumber)) {
            return true;
        }
        return false;
    }

    private static boolean checkInputInRange(String inputNumber) {
        if (Pattern.matches(numberPattern, inputNumber)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkInputDuplicate(String inputNumber) {
        int firstNum = inputNumber.charAt(0) - '0';
        int secondNum = inputNumber.charAt(1) - '0';
        int thirdNum = inputNumber.charAt(2) - '0';

        if (firstNum == secondNum
                || secondNum == thirdNum
                || thirdNum == firstNum) {
            return false;
        }
        return true;
    }
}
