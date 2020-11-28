package baseball.domain;

public class FixedNumbersGenerator implements NumbersGenerator {

    private final String numbers;

    public FixedNumbersGenerator(String numbers) {
        this.numbers = numbers;
    }

    @Override
    public String generateNumbers() {
        return numbers;
    }
}
