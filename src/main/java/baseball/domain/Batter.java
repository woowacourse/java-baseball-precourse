package baseball.domain;

public final class Batter extends Player {

    public Batter(final NumbersGenerator generator) {
        this.numbers = new Baseballs(generator.generateNumbers());
    }

    public Judgment swing(final int index, final int pitchedNumber) {
        if (numbers.isStrike(index, pitchedNumber)) {
            return Judgment.STRIKE;
        }

        if (numbers.isBall(pitchedNumber)) {
            return Judgment.BALL;
        }

        return Judgment.NOTHING;
    }
}
