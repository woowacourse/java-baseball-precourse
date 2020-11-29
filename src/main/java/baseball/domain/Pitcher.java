package baseball.domain;

public final class Pitcher extends Player {

    public Pitcher(final String balls) {
        this.baseballs = new Baseballs(balls);
    }

    public int pitch(final int numberIndex) {
        return this.baseballs.getNumber(numberIndex);
    }
}
