package baseball;

public class Ball {
    private final NumberGenerator numberGenerator;
    private int number;

    public Ball(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public NumberGenerator getNumberGenerator() {
        return numberGenerator;
    }

    public int getNumber() {
        return number;
    }

    public void generateNumber() {
        number = numberGenerator.generateNumber();
    }
}
