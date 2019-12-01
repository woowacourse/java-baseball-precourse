/*
 * @(#)NumberHitter.java 2019/12/1
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

package precourse.baseball.number;

import precourse.baseball.Hitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @version     1.00 2019년 12월 1일
 * @author      임근원
 */
public class NumberHitter extends NumberPlayer implements Hitter {
    /* NumberHitter는 숫자 야구 게임에 참여하는 타자입니다. */

    @Override
    public List<Integer> hit() {
        List<Integer> balls = new ArrayList<>();
        for (int i = 0; i < NumberBaseballConfig.ROUND; i++) {
            int ball = confirmBall(balls);
            balls.add(ball);
        }
        return balls;
    }
    private int confirmBall(List<Integer> balls) {
        Random randomGenerator = new Random();

        int ball = NumberBaseballConfig.MIN_BALL - 1;
        while (!isConfirmed(balls, ball)) {
            //todo: check if it is good
            ball = randomGenerator.ints(NumberBaseballConfig.MIN_BALL, NumberBaseballConfig.MAX_BALL + 1).limit(1).findFirst().getAsInt();
        }

        return ball;
    }
    private boolean isConfirmed(List<Integer> balls, int ball) {
        if (isOutOfRange(ball)) {
            return false;
        }

        return !balls.contains(ball);
    }
    private boolean isOutOfRange(int ball) {
        return ball < NumberBaseballConfig.MIN_BALL || NumberBaseballConfig.MAX_BALL < ball;
    }
}
