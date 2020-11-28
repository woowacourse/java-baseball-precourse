package baseball.domain;

public class Pitcher extends Player {

    public Pitcher(NumbersGenerator generator) {
        super(generator);
    }

    public BaseballNumbers pitches() {
        return new BaseballNumbers(generator.generateNumbers());
    }
}
