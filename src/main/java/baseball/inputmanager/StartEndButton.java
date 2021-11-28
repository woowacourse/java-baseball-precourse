package baseball.inputmanager;

public class StartEndButton extends InputManger<Integer>{
    private static final int NUMBER_OF_DIGITS_OF_INPUT_NUMBERS = 1;
    private static final int ASCII_VALUE_OF_START_NUMBER = '1';
    private static final int ASCII_VALUE_OF_END_NUMBER = '2';

    @Override
    boolean meetNumberOfDigitsLimit(String input) {
        return input.length() == NUMBER_OF_DIGITS_OF_INPUT_NUMBERS;
    }

    @Override
    boolean meetRangeOfCharacterLimit(String input) {
        for (Character c : input.toCharArray()) {
            if (ASCII_VALUE_OF_END_NUMBER < c || c < ASCII_VALUE_OF_START_NUMBER) {
                return false;
            }
        }
        return true;
    }

    @Override
    Integer toReturn(String input) {
        return Integer.parseInt(input);
    }
}
