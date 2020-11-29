package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumberCompare {

    public static List<Integer> counter(List<String> ballNumberList, List<String> playerBallSplitNumberList) {
        int strikeCounter = 0;
        int ballCounter = 0;

        for (int answerIndex = 0; answerIndex < 3; answerIndex++) {
            for (int playerIndex = 0; playerIndex < 3; playerIndex++) {
                if (answerIndex == playerIndex && ballNumberList.get(answerIndex).equals(playerBallSplitNumberList.get(playerIndex))) {
                    strikeCounter += 1;
                } else if (answerIndex != playerIndex && ballNumberList.get(answerIndex).equals(playerBallSplitNumberList.get(playerIndex))) {
                    ballCounter += 1;
                }
            }
        }
        List<Integer> resultCounter = new ArrayList<>();
        resultCounter.add(ballCounter);
        resultCounter.add(strikeCounter);
        return resultCounter;
    }
}
