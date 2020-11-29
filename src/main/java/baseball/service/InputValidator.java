package baseball.service;

import baseball.constant.Constants;
import utils.StringToListIntegerutils;

import java.util.List;

public class InputValidator {

    private InputValidator() {
    }

    public static boolean validateUserNumber(String userNumber) {
        return isNaturalNumberForUserNumber(userNumber)
                && isThreeDigitNumber(userNumber)
                && isNonZero(userNumber)
                && isAllDifferentNumber(userNumber);
    }

    public static boolean validateRetryNumber(String retryNumber) {
        return isNaturalNumberForRetryNumber(retryNumber)
                && isNumberOneOrTwo(retryNumber);
    }

    private static boolean isNaturalNumberForUserNumber(String number) {

        try {
            Integer.parseInt(number);
        } catch (NumberFormatException expected) {
            throw new IllegalArgumentException(Constants.PLEASE_INPUT_THREE_DIGIT_NUMBER);
        }

        return true;
    }

    private static boolean isThreeDigitNumber(String number) {

        if (number.length() != Constants.ANSWER_LENGTH) {
            throw new IllegalArgumentException(Constants.PLEASE_INPUT_THREE_DIGIT_NUMBER);
        }

        return true;
    }

    private static boolean isNonZero(String number) {

        if (number.contains(Constants.CONTAIN_ZERO)) {
            throw new IllegalArgumentException(Constants.PLEASE_INPUT_NON_ZERO_NUMBER);
        }

        return true;
    }

    private static boolean isAllDifferentNumber(String number) {
        List<Integer> numberList = StringToListIntegerutils.convertToList(number);

        if (numberList.stream().distinct().count() != Constants.ANSWER_LENGTH) {
            throw new IllegalArgumentException(Constants.PLEASE_INPUT_ALL_DIFFERENT_NUMBER);
        }

        return true;
    }

    private static boolean isNaturalNumberForRetryNumber(String number) {

        try {
            Integer.parseInt(number);

            if (number.length() > Constants.VALUE_ONE) {
                throw new IllegalArgumentException(Constants.PLEASE_INPUT_ONE_DIGIT_NUMBER);
            }

        } catch (NumberFormatException expected) {
            throw new IllegalArgumentException(Constants.PLEASE_INPUT_ONE_DIGIT_NUMBER);
        }

        return true;
    }

    private static boolean isNumberOneOrTwo(String number) {

        if (!(number.contains(Constants.RESTART) || number.contains(Constants.EXIT))) {
            throw new IllegalArgumentException(Constants.PLEASE_INPUT_ONE_DIGIT_NUMBER);
        }

        return true;
    }
}