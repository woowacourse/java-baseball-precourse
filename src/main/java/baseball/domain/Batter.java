package baseball.domain;

import baseball.domain.generator.NumbersGenerator;

public final class Batter extends Player {

    private final NumbersGenerator generator;

    public Batter(final NumbersGenerator generator) {
        this.generator = generator;
    }

    public Batter(final NumbersGenerator generator, final Baseballs baseballs) {
        this.generator = generator;
        this.baseballs = baseballs;
    }

    public Batter setNewAnswer() {
        return new Batter(generator, new Baseballs(generator.generateNumbers()));
    }

    public Judgment swing(final int index, final int pitchedNumber) {
        if (baseballs.isStrike(index, pitchedNumber)) {
            return Judgment.STRIKE;
        }

        if (baseballs.isBall(pitchedNumber)) {
            return Judgment.BALL;
        }

        return Judgment.NOTHING;
    }
}
