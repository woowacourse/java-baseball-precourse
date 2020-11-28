package baseball.domain;

public class Pitcher extends Player {

    public Pitcher(String balls) {
        this.numbers = new Baseballs(balls);
    }

    public int pitch(int numberIndex) {
        return this.numbers.getNumber(numberIndex);
    }
}
