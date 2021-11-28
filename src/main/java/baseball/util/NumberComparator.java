package baseball.util;

import baseball.GameNumber;
import baseball.PrintResult;

import java.util.List;

import static baseball.config.Constant.*;

public class NumberComparator {
    private static int strike;
    private static int ball;

    public static PrintResult compare(GameNumber computerNumber, GameNumber playerNumber) {
        List<Integer> computerNumberGameNumber = computerNumber.getGameNumber();
        List<Integer> playerNumberGameNumber = playerNumber.getGameNumber();

        for(int i = 0; i < computerNumberGameNumber.size(); i++) {
            checkStrikeOrBall(i, computerNumberGameNumber.get(i), playerNumberGameNumber);
        }

        return new PrintResult(strike, ball);
    }

    private static void checkStrikeOrBall(int computerIndex, int indexVal, List<Integer> playerNumberGameNumber) {
        int playerIndex = playerNumberGameNumber.indexOf(indexVal);

        if(playerIndex != INVALID_INDEX && playerIndex == computerIndex) {
            strike++;
        }

        if(playerIndex != INVALID_INDEX && playerIndex != computerIndex) {
            ball++;
        }
    }

    public static void clearStrikeAndBall() {
        strike = NONE;
        ball = NONE;
    }
}
