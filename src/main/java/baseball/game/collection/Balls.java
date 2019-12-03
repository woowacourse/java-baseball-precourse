package baseball.game.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static baseball.application.GameManager.GAME_SIZE;

public class Balls {
    private final List<Ball> balls;

    public Balls(Collection<? extends Integer> ballList) {
        balls = new ArrayList<>();
        if (ballList.size() != GAME_SIZE) {
            throw new IllegalArgumentException();
        }

        for (Integer num : ballList) {
            balls.add(new Ball(num));
        }
    }

}
