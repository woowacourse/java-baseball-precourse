package utils;

public class Validator {
    private final static String OUT_OF_VALID_NUM_RANGE = "잘못된 숫자를 입력하셨습니다.";
    private final static String NOT_NUMBER_TYPE = "잘못된 숫자를 입력하셨습니다.";

    public static void validateRestartInput(String input){
        int intInput;
        try {
            intInput = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_NUMBER_TYPE);
        }

        if (intInput != 1 && intInput != 2) throw new IllegalArgumentException(OUT_OF_VALID_NUM_RANGE);
    }
}
