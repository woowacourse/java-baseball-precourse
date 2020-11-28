package baseball.domain;

public final class Pitcher extends Player {

    public Pitcher(final String balls) {
        this.numbers = new Baseballs(balls);
    }

    public int pitch(final int numberIndex) {
        return this.numbers.getNumber(numberIndex);
    }
}
