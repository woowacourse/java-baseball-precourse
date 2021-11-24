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

    public void compareNumber() {
        for(int i = 0; i < computerNumber.length(); i++) {
            checkStrikeOrBall(i);
        }

        System.out.println("볼: " + ball + "   스트라이크: " + strike);
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

    public void clear() {
        strike = 0;
        ball = 0;
    }
}
