package baseball.model;

public class TargetNumber {
    private String number;
    private final TargetNumberGenerator generator;

    public TargetNumber(TargetNumberGenerator generator) {
        this.generator = generator;
    }

    public void generate() {
        this.number = generator.generate();
    }

    public String getNumber() {
        return number;
    }
}