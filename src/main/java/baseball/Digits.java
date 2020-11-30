package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Digits {
    private static final int NUMBER_LENGTH = 3;
    private final ArrayList<Digit> digits;

    private boolean isIncludeDuplication(final int hundsDigit,final int tensDigit,final int unitsDigit) {
        HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(hundsDigit, tensDigit, unitsDigit));
        return !(set.size() == NUMBER_LENGTH);
    }

    private void validateLength(final int input) throws IllegalArgumentException {
        if (Integer.toString(input).length() != NUMBER_LENGTH){
            throw new IllegalArgumentException("입력하는 수가 " + NUMBER_LENGTH + "자리여야 합니다.");
        }
    }

    private void validateDuplication(final int hundsDigit,final int tensDigit,final int unitsDigit) throws IllegalArgumentException {
        if (isIncludeDuplication(hundsDigit, tensDigit, unitsDigit)){
            throw new IllegalArgumentException("입력하는 수의 각 자리 수는 다른 수여야 합니다.");
        }
    }

    private ArrayList<Digit> makeDigits(final int hundDigit, final int tensDigit, final int unitsDigit) {
       return new ArrayList<Digit>(Arrays.asList(new Digit(hundDigit), new Digit(tensDigit), new Digit(unitsDigit)));
    }

    public int indexOfDigit(int index) {
        return digits.get(index).getDigit();
    }

    public Digits(final int input) {
        validateLength(input);

        int hundsDigit = input / 100;
        int tensDigit = (input % 100) / 10;
        int unitsDigit = input % 10;

        validateDuplication(hundsDigit, tensDigit, unitsDigit);
        digits = makeDigits(hundsDigit, tensDigit, unitsDigit);
    }
}
