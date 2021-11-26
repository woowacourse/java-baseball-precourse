package baseball.utils;

public class InputValidator {

    public static final int INPUT_NUMBER_MIN = 111;
    public static final int INPUT_NUMBER_MAX = 999;

    private InputValidator() {}

    public static void validateInteger(String input) {
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateInRange(String input) {
        try{
            int integerInput = Integer.parseInt(input);
            if(integerInput < INPUT_NUMBER_MIN || integerInput > INPUT_NUMBER_MAX) {
                throw new IllegalArgumentException();
            }
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateUniqueDigits(String input) {
        try{
            Integer.parseInt(input);

            int uniqueDigitCount = Long.valueOf(input.chars().distinct().count()).intValue();
            if(uniqueDigitCount != RandomDigitsGenerator.RANDOM_DIGIT_COUNT) {
                throw new IllegalArgumentException();
            }
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateAll(String input) {
        validateInteger(input);
        validateInRange(input);
        validateUniqueDigits(input);
    }
}
