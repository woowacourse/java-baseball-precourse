package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NumberValidator {

    private static final int VALID_LENGTH = 3;

    ArrayList<Integer> numbers;

    NumberValidator(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean isValid() {
        return (isValidLength() && isNotZero() && isNonRedundant());
    }

    private boolean isValidLength() {
        return numbers.size() == VALID_LENGTH;
    }

    private boolean isNotZero() {
        for (int number : numbers) {
            if (number == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isNonRedundant() {
        Set<Integer> numberSet = new HashSet<>(numbers);
        return numberSet.size() == numbers.size();
    }
}



