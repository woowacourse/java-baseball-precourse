package com.nekisse.baseball;

public class Referee {

    private final BaseballNumbers baseballGameNumbers;

    Referee(BaseballNumbers baseballGameNumbers) {
        this.baseballGameNumbers = baseballGameNumbers;
    }

    GameTurnResult compareGameNumberResult(BaseballNumbers userBaseBallNumbers) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < baseballGameNumbers.getThreeNumber().size(); i++) {
            strikeCount += matchStrikeCount(userBaseBallNumbers, i);
            ballCount += matchBallCount(userBaseBallNumbers, i);
        }
        return new GameTurnResult(strikeCount, ballCount);
    }

    private int matchStrikeCount(BaseballNumbers userBaseBallNumbers, int index) {
        return isStrike(userBaseBallNumbers, index) ? 1 : 0;
    }

    private boolean isStrike(BaseballNumbers userBaseBallNumbers, int index) {
        return baseballGameNumbers.getThreeNumber().get(index).equals(userBaseBallNumbers.getThreeNumber().get(index));
    }

    private int matchBallCount(BaseballNumbers userBaseBallNumbers, int index) {
        return isaBall(userBaseBallNumbers, index) ? 1 : 0;
    }

    private boolean isaBall(BaseballNumbers userBaseBallNumbers, int index) {
        return !isStrike(userBaseBallNumbers, index) && baseballGameNumbers.getThreeNumber().contains(userBaseBallNumbers.getNumber(index));
    }
}
