package baseball.domain;

public class Number {
    int[] gameNumbers;
    int[] userNumbers;

    public Number(int size) {
        gameNumbers = new int[size];
        userNumbers = new int[size];
    }

    public int[] getGameNumbers() {
        return gameNumbers;
    }

    public int[] getUserNumbers() {
        return userNumbers;
    }

    public void setGameNumbers(int[] gameNumbers) {
        this.gameNumbers = gameNumbers;
    }

    public void setUserNumbers(int[] userNumbers) {
        this.userNumbers = userNumbers;
    }
}
