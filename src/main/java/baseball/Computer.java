package baseball;

public class Computer {

    public static final int NUMBER_LENGTH = 3;

    private final NumberGenerator numberGenerator;

    public Computer(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public String generateAnswer() {
        return numberGenerator.generateNumber(NUMBER_LENGTH);
    }
}
