package baseball.game.util;

import baseball.game.collection.Balls;

public interface BallGenerator {
    Balls getBalls(int size);
}
