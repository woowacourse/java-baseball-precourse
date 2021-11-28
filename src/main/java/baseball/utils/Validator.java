package baseball.utils;

import static baseball.constants.NumberConstant.ANSWER_LIST_LENGTH;
import static baseball.constants.NumberConstant.END_GAME_NUM;
import static baseball.constants.NumberConstant.RANGE_END_NUM;
import static baseball.constants.NumberConstant.RANGE_START_NUM;
import static baseball.constants.NumberConstant.RESTART_NUM;
import static baseball.constants.OutputMessage.NOT_NUMBER_TYPE_ERROR;
import static baseball.constants.OutputMessage.OUT_OF_VALID_NUM_RANGE_ERROR;
import static baseball.constants.OutputMessage.SAME_NUMBER_ERROR;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static void validateAnswerInput(String input) {
        String[] inputStringNums = input.split("");
        List<Integer> inputIntNums = new ArrayList<>();

        for (String s : inputStringNums) {
            int intInput = validateAndParseToIntType(s);
            validateIntRange(intInput, RANGE_START_NUM, RANGE_END_NUM);
            inputIntNums.add(intInput);
        }

        validateUniqueNumber(inputIntNums);
        validateAnswerLength(inputIntNums);
    }

    public static void validateRestartInput(String input) {
        int intInput = validateAndParseToIntType(input);
        validateIntRange(intInput, RESTART_NUM, END_GAME_NUM);
    }

    public static void validateUniqueNumber(List<Integer> intList) {
        boolean[] visited = new boolean[RANGE_END_NUM + 1];

        for (int value : intList) {
            if (visited[value]) throw new IllegalArgumentException(SAME_NUMBER_ERROR);
            visited[value] = true;
        }
    }

    public static void validateAnswerLength(List<Integer> inputStringNums) {
        if (inputStringNums.size() != ANSWER_LIST_LENGTH) {
            throw new IllegalArgumentException(NOT_NUMBER_TYPE_ERROR);
        }
    }

    private static int validateAndParseToIntType(String string) {
        try {
            return Integer.parseInt(string);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_NUMBER_TYPE_ERROR);
        }
    }

    private static void validateIntRange(int input, int min, int max) {
        if (input < min || input > max) {
            throw new IllegalArgumentException(OUT_OF_VALID_NUM_RANGE_ERROR);
        }
    }
}
