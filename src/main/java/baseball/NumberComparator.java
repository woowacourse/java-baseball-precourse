package baseball;

public class NumberComparator {

    private String playerNumber;
    private String computerNumber;
    private int strike;
    private int ball;

    public void setComputerNumber(String computerNumber) {
        this.computerNumber = computerNumber;
    }

    public void setPlayerNumber(String playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void run(String playerNumber) {
        clear();
        setPlayerNumber(playerNumber);
        compareNumber();

    }
    private void compareNumber() {
        for(int i = 0; i < computerNumber.length(); i++) {
            checkStrikeOrBall(i);
        }
    }

    private void checkStrikeOrBall(int computerIndex) {

        int playerIndex = playerNumber.indexOf(computerNumber.charAt(computerIndex));

        if (playerIndex != -1 && playerIndex == computerIndex) {
            strike++;
        }

        if (playerIndex != -1 && playerIndex != computerIndex) {
            ball++;
        }
    }

    private void clear() {
        strike = 0;
        ball = 0;
    }
}
