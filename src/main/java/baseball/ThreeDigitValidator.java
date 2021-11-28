package baseball;

public class ThreeDigitValidator implements NumberValidator {

    @Override
    public boolean validateNumber(int number) {
        return number < 1000 && number >= 100;
    }
}
