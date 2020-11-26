package baseball;

public class Game {
    private int targetNumber;

    public Game(int targetNumber) {
        this.targetNumber = targetNumber;
    }

    public String getHint(int inputNUmber) {
        return "1볼 1스트라이크";
    }

    public boolean isAnswer(int inputNumber) {
        return targetNumber == inputNumber;
    }
}
