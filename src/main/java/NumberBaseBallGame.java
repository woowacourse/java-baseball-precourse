/*
 * @(#)NumberBaseBallGame.java
 *
 * v 0.0.0
 *
 * 2019.11.28
 *
 * Copyright 2019. DunDung all rights reserved.
 */

public class NumberBaseBallGame {
    public static final int DIGIT = 3;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;
    public static final int ANSWER_STRIKE = 3;
    private String randomNumber;
    private String playerNumber;
    private GameResult gameResult;

    public GameResult calculateResult() {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i=0; i<DIGIT; i++) {
            if (randomNumber.charAt(i) == playerNumber.charAt(i)){
                strikeCount++;
            } else if (randomNumber.indexOf(playerNumber.charAt(i)) != -1) {
                ballCount++;
            }
        }

        GameResult aGameResult = new GameResult();
        aGameResult.setStrike(strikeCount);
        aGameResult.setBall(ballCount);

        return aGameResult;
    }
    public boolean isAnswer() {
        return gameResult.getStrike() == ANSWER_STRIKE;
    }
    public void setGameResult(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    public void setRandomNumbers(String randomNumber) {
        this.randomNumber = randomNumber;
    }

    public void setPlayerNumber(String playerNumber) {
        this.playerNumber = playerNumber;
    }



}
