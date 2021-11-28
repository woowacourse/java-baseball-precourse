package baseball;

import java.util.List;

public class ThreeDigitValidator implements NumberValidator {

    @Override
    public boolean validateNumber(int number) {
        return number < 1000 && number >= 100;
    }

    @Override
    public boolean validateNumber(List<Integer> numbers) {
        return numbers.size() == 3;
    }
}
