package baseball.game.computer;

import baseball.game.collection.Balls;

public interface Calculator {
    boolean isWin(Balls computerBalls, Balls userBalls);
}
