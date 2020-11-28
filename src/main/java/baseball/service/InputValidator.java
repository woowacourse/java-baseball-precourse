package baseball.service;

import baseball.constant.Constants;
import baseball.view.OutputView;
import com.sun.tools.classfile.ConstantPool;
import utils.StringToListIntegerutils;

import java.util.List;

public class InputValidator {

    private InputValidator() {}

    public static boolean validateUserNumber(String userNumber) {
        return isNaturalNumber(userNumber)
                && isThreeDigitNumber(userNumber)
                && isNonZero(userNumber)
                && isAllDifferentNumber(userNumber);
    }

    public static boolean validateRetryNumber(String retryNumber) {
        return isNaturalNumber(retryNumber)
                && isNumberOneOrTwo(retryNumber);
    }

    private static boolean isNaturalNumber(String number) {

        try {
            Integer.parseInt(number);
        } catch (IllegalArgumentException expected) {
            OutputView.ERROR_MESSAGE = Constants.PLEASE_INPUT_THREE_DIGIT_NUMBER;
            return false;
        }

        return true;
    }

    private static boolean isThreeDigitNumber(String number) {

        if (number.length() != Constants.ANSWER_LENGTH) {
            OutputView.ERROR_MESSAGE = Constants.PLEASE_INPUT_THREE_DIGIT_NUMBER;
            return false;
        }

        return true;
    }

    private static boolean isNonZero(String number) {

        if (number.contains(Constants.CONTAIN_ZERO)) {
            OutputView.ERROR_MESSAGE = Constants.PLEASE_INPUT_NON_ZERO_NUMBER;
            return false;
        }

        return true;
    }

    private static boolean isAllDifferentNumber(String number) {
        List<Integer> numberList = StringToListIntegerutils.convertToList(number);

        if (numberList.stream().distinct().count() != Constants.ANSWER_LENGTH) {
            OutputView.ERROR_MESSAGE = Constants.PELASE_INPUT_ALL_DIFFERENT_NUMBER;
            return false;
        }

        return true;
    }

    private static boolean isNumberOneOrTwo(String number) {

        if (!(number.contains(Constants.RESTART) || number.contains(Constants.EXIT))) {
            OutputView.ERROR_MESSAGE = Constants.PLEASE_INPUT_RETRY_NUMBER;
            return false;
        }

        return true;
    }
}
