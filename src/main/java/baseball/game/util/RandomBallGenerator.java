package baseball.game.util;

import baseball.game.collection.Balls;

import java.util.HashSet;
import java.util.Set;

import static baseball.application.GameManager.GAME_SIZE;

public class RandomBallGenerator implements BallGenerator {
    @Override
    public Balls getBalls(int size) {
        //size 만큼 랜덤하게.
        Set<Integer> numSet = new HashSet<>();
        while (numSet.size() < GAME_SIZE) {
            numSet.add(getRandomValue());
        }

        return new Balls(numSet);
    }

    private int getRandomValue() {
        return (int) (Math.random() * 9) + 1;
    }
}
