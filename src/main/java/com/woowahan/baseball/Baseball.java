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
        ArrayList<Integer> ballRange = new ArrayList<Integer>();

        for(int i = 1; i <= 9; i++){
            ballRange.add(i);
        }

        return ballRange;
    }

    @Override
    protected Integer getRandomBall(ArrayList<Integer> range) {
        int randIdx;
        randIdx = getRandomInteger(0, range.size() - 1);

        return range.get(randIdx);
    }

    @Override
    protected ArrayList<Integer> getRandomBalls() {
        ArrayList<Integer> range, randomBalls;
        range = initializeBallRange();
        randomBalls = new ArrayList<Integer>();

        for(int i = 1; i <= 3; i++){
            int randomBall = getRandomBall(range);
            randomBalls.add(randomBall);
            range.remove(range.indexOf(randomBall));
        }

        return randomBalls;
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
