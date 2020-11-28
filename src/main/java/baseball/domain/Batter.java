package baseball.domain;

public class Batter extends Player {

    private final NumbersGenerator generator;

    public Batter(NumbersGenerator generator) {
        this.generator = generator;
        this.numbers = new BaseballNumbers(generator.generateNumbers());
    }

    public Judgment swing(int index, int pitchedNumber) {
        if (numbers.isStrike(index, pitchedNumber)) {
            return Judgment.STRIKE;
        }

        if (numbers.isBall(pitchedNumber)) {
            return Judgment.BALL;
        }

        return Judgment.NOTHING;
    }
}
