package baseball.utils;

import static baseball.Constants.ANSWER_LIST_LENGTH;
import static baseball.Constants.END_GAME_NUM;
import static baseball.Constants.NOT_NUMBER_TYPE_ERROR;
import static baseball.Constants.OUT_OF_VALID_NUM_RANGE_ERROR;
import static baseball.Constants.RANGE_END_NUM;
import static baseball.Constants.RANGE_START_NUM;
import static baseball.Constants.RESTART_NUM;

public class Validator {

    public static void validateIntRange(int input, int min, int max) {
        if (input < min || input > max) throw new IllegalArgumentException(OUT_OF_VALID_NUM_RANGE_ERROR);
    }

    public static void validateAnswerInput(String input) {
        String[] inputNums = input.split("");
        validateAnswerInputLength(inputNums);

        int inputNum;
        for (String s : inputNums) {
            try {
                inputNum = Integer.parseInt(s);
                validateIntRange(inputNum, RANGE_START_NUM, RANGE_END_NUM);
            } catch (Exception e) {
                throw new IllegalArgumentException(NOT_NUMBER_TYPE_ERROR);
            }
        }
    }

    public static void validateAnswerInputLength(String[] inputNums) {
        if (inputNums.length != ANSWER_LIST_LENGTH) {
            throw new IllegalArgumentException(NOT_NUMBER_TYPE_ERROR);
        }
    }

    public static void validateRestartInput(String input){
        int intInput;
        try {
            intInput = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_NUMBER_TYPE_ERROR);
        }

        validateIntRange(intInput, RESTART_NUM, END_GAME_NUM);
    }
}
