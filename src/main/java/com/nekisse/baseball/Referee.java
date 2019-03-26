package com.nekisse.baseball;

import java.util.List;

public class Referee {

    private final List<Integer> baseballGameNumbers;

    public Referee(List<Integer> baseballGameNumbers) {
        this.baseballGameNumbers = baseballGameNumbers;

    }

    public GameTurnResult compareGameNumberResult(List<Integer> userBaseBallNumbers) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < baseballGameNumbers.size(); i++) {
            strikeCount += matchStrikeCount(userBaseBallNumbers, i);
            ballCount += matchBallCount(userBaseBallNumbers, i);
        }
        return new GameTurnResult(strikeCount, ballCount);
    }

    private int matchStrikeCount(List<Integer> userBaseBallNumbers, int index) {
        return isStrike(userBaseBallNumbers, index) ? 1 : 0;
    }

    private boolean isStrike(List<Integer> userBaseBallNumbers, int index) {
        return baseballGameNumbers.get(index).equals(userBaseBallNumbers.get(index));
    }

    private int matchBallCount(List<Integer> userBaseBallNumbers, int index) {
        return isaBall(userBaseBallNumbers, index) ? 1 : 0;
    }

    private boolean isaBall(List<Integer> userBaseBallNumbers, int index) {
        return !isStrike(userBaseBallNumbers, index) && baseballGameNumbers.contains(userBaseBallNumbers.get(index));
    }
}
