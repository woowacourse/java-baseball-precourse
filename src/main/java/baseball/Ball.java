package baseball;

public class Ball {
    private final NumberGenerator numberGenerator;
    private final NumberValidator numberValidator;
    private int number;

    public Ball(NumberGenerator numberGenerator, NumberValidator numberValidator) {
        this.numberGenerator = numberGenerator;
        this.numberValidator = numberValidator;
    }

    public NumberGenerator getNumberGenerator() {
        return numberGenerator;
    }

    public NumberValidator getNumberValidator() {
        return numberValidator;
    }

    public int getNumber() {
        return number;
    }

    public void generateNumber() {
        number = numberGenerator.generateNumber();
        while (!numberValidator.validateNumber(number)) {
            number = numberGenerator.generateNumber();
        }
    }
}
