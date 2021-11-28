package baseball;

import java.util.List;

public class NumberComparator {
    private static int strike;
    private static int ball;

    public static void compare(GameNumber computerNumber, GameNumber playerNumber) {
        List<Integer> computerNumberGameNumber = computerNumber.getGameNumber();
        List<Integer> playerNumberGameNumber = playerNumber.getGameNumber();

        for(int i = 0; i < computerNumberGameNumber.size(); i++) {
            checkStrikeOrBall(i, computerNumberGameNumber.get(i), playerNumberGameNumber);
        }
    }

    private static void checkStrikeOrBall(int computerIndex, int indexVal, List<Integer> playerNumberGameNumber) {
        int playerIndex = playerNumberGameNumber.indexOf(indexVal);

        if(playerIndex != -1 && playerIndex == computerIndex) {
            strike++;
        }

        if(playerIndex != -1 && playerIndex != computerIndex) {
            ball++;
        }
    }

    public static void clearStrikeAndCount() {
        strike = 0;
        ball = 0;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
