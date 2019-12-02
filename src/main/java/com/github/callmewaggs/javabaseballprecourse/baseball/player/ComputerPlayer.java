package com.github.callmewaggs.javabaseballprecourse.baseball.player;

import com.github.callmewaggs.javabaseballprecourse.baseball.Ball;

import java.util.*;

public class ComputerPlayer implements BallPlayer{
    private Ball ball;

    @Override
    public void prepareBall() {
        LinkedHashSet<Integer> candidates = new LinkedHashSet<>();

        while (candidates.size() < 3) {
            int number = (int) (Math.random() * 1000) % 9 + 1;
            candidates.add(number);
        }

        this.ball = new Ball(candidates);
    }

    @Override
    public Ball getBall() {
        return this.ball;
    }

}
