package baseball.domain;

public class Pitcher extends Player {

    public Pitcher(NumbersGenerator generator) {
        super(generator);
    }

    public int pitch(int numberIndex) {
        return this.numbers.getNumber(numberIndex);
    }
}
