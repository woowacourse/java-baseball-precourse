package baseball;

import java.util.List;

public class Computer {
    private final NumberGenerator numberGenerator;
    private final NumberValidator numberValidator;
    private List<Integer> number;

    public Computer(NumberGenerator numberGenerator, NumberValidator numberValidator) {
        this.numberGenerator = numberGenerator;
        this.numberValidator = numberValidator;
    }

    public NumberGenerator getNumberGenerator() {
        return numberGenerator;
    }

    public NumberValidator getNumberValidator() {
        return numberValidator;
    }

    public List<Integer> getNumber() {
        return number;
    }

    public void generateNumber() {
        number = numberGenerator.generateNumber();
        while (!numberValidator.validateNumber(number)) {
            number = numberGenerator.generateNumber();
        }
    }
}
