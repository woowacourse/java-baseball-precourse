package baseball.domain;

public abstract class Player {

    protected final NumbersGenerator generator;

    protected BaseballNumbers numbers;

    protected final Validator validator;

    public Player(NumbersGenerator generator) {
        this.generator = generator;
        this.validator = new Validator();
    }
}
