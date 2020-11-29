package baseball;

import java.util.List;

public class BaseballNumberCompare {

    public static BaseballCounterResult compare(List<String> ballNumberList, List<String> playerBallSplitNumberList) {

        BaseballCounterResult baseballCounterResult = new BaseballCounterResult();

        for (int answerIndex = 0; answerIndex < 3; answerIndex++) {
            for (int playerIndex = 0; playerIndex < 3; playerIndex++) {
                if (answerIndex == playerIndex && ballNumberList.get(answerIndex).equals(playerBallSplitNumberList.get(playerIndex))) {
                    baseballCounterResult.increaseStrike();
                } else if (answerIndex != playerIndex && ballNumberList.get(answerIndex).equals(playerBallSplitNumberList.get(playerIndex))) {
                    baseballCounterResult.increaseBall();
                }
            }
        }
        return baseballCounterResult;
    }
}

