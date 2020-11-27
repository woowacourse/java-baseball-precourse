package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Digits {
    private static final int NUMBER_LENGTH = 3;
    private final ArrayList<Digit> digits;

    private boolean includeDuplication(final int hundsDigit,final int tensDigit,final int unitsDigit){
        HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(hundsDigit, tensDigit, unitsDigit));
        return !(set.size() == NUMBER_LENGTH);
    }

    private void validateLength(final int input){
        if (Integer.toString(input).length() != NUMBER_LENGTH){
            throw new IllegalArgumentException("입력하는 수가" + NUMBER_LENGTH + "자리여야 합니다.");
        }
    }

    private void validateDuplication(final int hundsDigit,final int tensDigit,final int unitsDigit){
        if (includeDuplication(hundsDigit, tensDigit, unitsDigit)){
            throw new IllegalArgumentException("입력하는 수의 각 자리 수는 다른 수여야 합니다.");
        }
    }

    private ArrayList<Digit> makeDigits(final int hundDigit, final int tensDigit, final int unitsDigit){
        ArrayList<Digit> number = new ArrayList<Digit>();
        number.add(new Digit(hundDigit));
        number.add(new Digit(tensDigit));
        number.add(new Digit(unitsDigit));
        return number;
    }

    public Digits(final int input){
        validateLength(input);

        int hundsDigit = input / 100;
        int tensDigit = (input % 100) / 10;
        int unitsDigit = input % 10;

        validateDuplication(hundsDigit, tensDigit, unitsDigit);
        digits = makeDigits(hundsDigit, tensDigit, unitsDigit);
    }
}
