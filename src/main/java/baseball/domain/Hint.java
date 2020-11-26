/*
 * Hint.java
 *
 * version 1.0
 *
 * 2020/11/27
 *
 * Copyright (c) 2020 Junhyoung Park
 */

package baseball.domain;

public class Hint {

    private static final int NUMBER_LENGTH = 3;

    private String playerNumber;
    private String randomNumber;
    private int strike;
    private int ball;

    public Hint(String playerNumber, String randomNumber) {
        this.playerNumber = playerNumber;
        this.randomNumber = randomNumber;
    }

    public boolean isWinning() {
        return strike == NUMBER_LENGTH;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void startGame() {
        initialize();
        setStrikeOrBall();
    }

    private void initialize() {
        int strike = 0;
        int ball = 0;
    }

    private boolean isStrike(int index) {
        return playerNumber.charAt(index) == randomNumber.charAt(index);
    }

    private boolean isBall(int index) {
        return randomNumber.contains((Character.toString(playerNumber.charAt(index))));
    }

    private void setStrikeOrBall() {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (isStrike(i)) {
                strike++;
                ball--;
            }
            if (isBall(i)) {
                ball++;
            }
        }
    }

}
