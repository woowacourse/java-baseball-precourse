package baseball.game.computer;

import baseball.game.collection.Balls;


public class OriginalCalculator implements Calculator {

    @Override
    public boolean isWin(Balls computerBalls, Balls userBalls) {
        return computerBalls.isAllMatch(userBalls);
    }
}
