package baseball.domain.generator;

public final class FixedNumbersGenerator implements NumbersGenerator {

    private final String numbers;

    public FixedNumbersGenerator(final String numbers) {
        this.numbers = numbers;
    }

    @Override
    public String generateNumbers() {
        return numbers;
    }
}
