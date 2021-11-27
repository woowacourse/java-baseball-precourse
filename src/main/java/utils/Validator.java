package utils;

public class Validator {
    private final static String OUT_OF_VALID_NUM_RANGE = "잘못된 숫자를 입력하셨습니다.";
    private final static String NOT_NUMBER_TYPE = "잘못된 값을 입력하셨습니다.";

    public static void validateIntRange(int input, int min, int max) {
        if (input < min || input > max) throw new IllegalArgumentException(OUT_OF_VALID_NUM_RANGE);
    }

    public static void validateAnswerInput(String input) {
        String[] inputNums = input.split("");
        validateAnswerInputLength(inputNums);

        int inputNum;
        for (String s : inputNums) {
            try {
                inputNum = Integer.parseInt(s);
                validateIntRange(inputNum, 1, 9);
            } catch (Exception e) {
                throw new IllegalArgumentException(NOT_NUMBER_TYPE);
            }
        }
    }

    public static void validateAnswerInputLength(String[] inputNums) {
        if (inputNums.length != 3) {
            throw new IllegalArgumentException(NOT_NUMBER_TYPE);
        }
    }

    public static void validateRestartInput(String input){
        int intInput;
        try {
            intInput = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_NUMBER_TYPE);
        }

        validateIntRange(intInput, 1, 2);
    }
}
