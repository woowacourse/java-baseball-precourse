package baseball.utils;

import static baseball.constants.NumberConstant.ANSWER_LIST_LENGTH;
import static baseball.constants.NumberConstant.END_GAME_NUM;
import static baseball.constants.NumberConstant.RANGE_END_NUM;
import static baseball.constants.NumberConstant.RANGE_START_NUM;
import static baseball.constants.NumberConstant.RESTART_NUM;
import static baseball.constants.OutputMessage.NOT_NUMBER_TYPE_ERROR;
import static baseball.constants.OutputMessage.OUT_OF_VALID_NUM_RANGE_ERROR;
import static baseball.constants.OutputMessage.SAME_NUMBER_ERROR;

public class Validator {

    public static void validateIntRange(int input, int min, int max) {
        if (input < min || input > max) throw new IllegalArgumentException(OUT_OF_VALID_NUM_RANGE_ERROR);
    }

    public static void validateUniqueNumberInput(int[] counter) {
        for (int i : counter) {
            if (i >= 2) throw new IllegalArgumentException(SAME_NUMBER_ERROR);
        }
    }

    public static void validateAnswerInput(String input) {
        String[] inputNums = input.split("");
        int[] counter = new int[RANGE_END_NUM + 1];

        validateAnswerInputLength(inputNums);

        int inputNum;
        for (String s : inputNums) {
            try {
                inputNum = Integer.parseInt(s);
                validateIntRange(inputNum, RANGE_START_NUM, RANGE_END_NUM);
                counter[inputNum] += 1;
            } catch (Exception e) {
                throw new IllegalArgumentException(NOT_NUMBER_TYPE_ERROR);
            }
        }

        validateUniqueNumberInput(counter);
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
