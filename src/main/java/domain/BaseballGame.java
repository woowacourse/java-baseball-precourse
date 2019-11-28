/*
 * BaseballGame.java
 * java-baseball-precourse
 *
 * Version 0.1
 *
 * Created by 김경준 on 27/11/2019.
 *
 * Copyright © 2019 kouz95. All rights reserved.
 */

package domain;

import java.util.ArrayList;

public class BaseballGame {
    private static final int NUM_LEN = 3;

    private final ArrayList<Integer> userInputNumberList;
    private final ArrayList<Integer> targetNumberList;
    private int strikeNumber = 0;
    private int ballNumber = 0;
    private boolean isWinning = false;
    private boolean isNothing = false;

    public BaseballGame(ArrayList<Integer> userInputNumberList, ArrayList<Integer> targetNumberList) {
        this.userInputNumberList = userInputNumberList;
        this.targetNumberList = targetNumberList;
        setGameState();
    }

    private void setGameState() {
        setStrikeNumber();
    }

    private void setStrikeNumber() {
        for (int i = 0; i < NUM_LEN; i++) {
            strikeNumber = userInputNumberList.get(i).equals(targetNumberList.get(i)) ?
                    strikeNumber + 1 : strikeNumber;
        }
    }
}
