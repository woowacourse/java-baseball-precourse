package baseball;

import java.util.List;

public interface NumberValidator {
    boolean validateNumber(int number);
    boolean validateNumber(List<Integer> numbers);
}
