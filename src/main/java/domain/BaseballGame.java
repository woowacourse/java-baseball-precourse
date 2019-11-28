/*
 * BaseballGame.java
 * java-baseball-precourse
 *
 * Version 0.6
 *
 * Created by 김경준 on 28/11/2019.
 *
 * Copyright © 2019 kouz95. All rights reserved.
 */

package domain;

import java.util.ArrayList;

public class BaseballGame {
    private static final int NUM_LEN = 3;

    private final ArrayList<Integer> userInputNumberList;
    private final ArrayList<Integer> targetNumberList;
    private int strikeNumber;
    private int ballNumber;
    private boolean isWinning;
    private boolean isNothing;

    public BaseballGame(ArrayList<Integer> userInputNumberList, ArrayList<Integer> targetNumberList) {
        this.userInputNumberList = userInputNumberList;
        this.targetNumberList = targetNumberList;
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

    private boolean isStrike(int listIndex) {
        return userInputNumberList.get(listIndex).equals(targetNumberList.get(listIndex));
    }

    private boolean isBall(int listIndex) {
        return targetNumberList.contains(userInputNumberList.get(listIndex));
    }

    private void setIsNothing() {
        if(strikeNumber == 0 && ballNumber == 0) {
            isNothing = true;
        }
    }

    private void setIsWinning() {
        if(strikeNumber == NUM_LEN) {
            isWinning = true;
        }
    }
}
