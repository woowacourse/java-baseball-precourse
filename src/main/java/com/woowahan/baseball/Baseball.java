package com.woowahan.baseball;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Baseball extends AbstractBaseball{
    @Override
    protected Integer getRandomInteger(int min, int max) {
        Random random = new Random();
        return random.nextInt(max-min) + min;
    }

    @Override
    protected String getLine() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    @Override
    protected ArrayList<Integer> initializeBallRange() {
        return null;
    }

    @Override
    protected Integer getRandomBall(ArrayList<Integer> range) {
        return null;
    }

    @Override
    protected ArrayList<Integer> getRandomBalls() {
        return null;
    }

    @Override
    protected EarlyResults.EarlyResult evaluateBall(Integer ball, ArrayList<Integer> balls) {
        return null;
    }

    @Override
    protected EarlyResults evaluateBalls(ArrayList<Integer> user, ArrayList<Integer> answer) {
        return null;
    }

    @Override
    public void Process() {

    }
}
