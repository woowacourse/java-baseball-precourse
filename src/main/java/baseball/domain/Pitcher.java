package baseball.domain;

public class Pitcher extends Player {

    public Pitcher(NumbersGenerator generator) {
        super(generator);
    }

    public void receiveBalls() {
        this.numbers = new BaseballNumbers(generator.generateNumbers());
    }

    public int pitch(int numberIndex) {
        return numbers.getNumber(numberIndex);
    }
}
