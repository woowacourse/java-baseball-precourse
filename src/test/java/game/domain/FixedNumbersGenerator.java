
/*
 * FixedNumbersGenerator.java
 * @author crystal_rim
 * @version 1.0.0
 * @date 2019-12-02
 */
package game.domain;

public class FixedNumbersGenerator implements NumbersGenerator{
    private final String numbers;

    FixedNumbersGenerator(String numbers) {
        this.numbers = numbers;
    }

    @Override
    public String generate() {
        return numbers;
    }
}
