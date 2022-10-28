package baseball.manager;

import java.util.ArrayList;

public class CheckTotalGameStatus {
    private final ArrayList<Integer> userNumber;
    private final ArrayList<Integer> computerNumber;
    private int strikeNumber;
    private int ballNumber;
    private boolean isWinning;
    private boolean isNothing;
    private final int NUM_LEN = 3;

    public CheckTotalGameStatus(ArrayList<Integer> userNumber, ArrayList<Integer> computerNumber) {
        this.userNumber = userNumber;
        this.computerNumber = computerNumber;
        setGameState();
    }
    public int getStrikeNumber() {
        return strikeNumber;
    }

    public int getBallNumber() {
        return ballNumber;
    }

    public boolean getIsWinning() {
        return isWinning;
    }

    public boolean getIsNothing() {
        return isNothing;
    }

    private void setGameState() {
        initializeGame();
        setStrikeAndBallNumber();
        setIsNothing();
        setIsWinning();
    }

    private void initializeGame() {
        strikeNumber = 0;
        ballNumber = 0;
        isWinning = false;
        isNothing = false;
    }

    private void setStrikeAndBallNumber() {

        for (int i = 0; i < NUM_LEN; i++) {

            if(isStrike(i)) {
                strikeNumber++;
                continue;
            }

            if(isBall(i)) {
                ballNumber++;
            }

        }
    }

    private boolean isStrike(int index) {
        return userNumber.get(index).equals(computerNumber.get(index));
    }

    private boolean isBall(int index) {
        return computerNumber.contains(userNumber.get(index));
    }

    private void setIsNothing() {
        isNothing = strikeNumber == 0 && ballNumber == 0;
    }

    private void setIsWinning() {

        if(strikeNumber == NUM_LEN) {
            isWinning = true;
        }

    }
}
