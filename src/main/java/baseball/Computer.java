package baseball;

public class Computer {


    private final NumberGenerator numberGenerator;

    public Computer(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public String generateAnswer() {
        return numberGenerator.generateNumber(GameConstant.NUMBER_LENGTH);
    }
}
