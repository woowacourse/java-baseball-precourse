package com.woowahan.baseball;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import com.woowahan.baseball.BallsResult.BallResult;

public class Baseball extends AbstractBaseball{
    @Override
    protected Integer getRandomInteger(int min, int max) {
        Random random = new Random();
        return random.nextInt(max-min) + min;
    }

    @Override
    public String getLine() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    protected ArrayList<Integer> stringToArrayList(String ballsString){
        ArrayList<Integer> balls = new ArrayList<Integer>();

        int ballsInt = Integer.parseInt(ballsString);

        balls.add(ballsInt/100);
        balls.add(ballsInt/10%10);
        balls.add(ballsInt%10);

        return balls;
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

        for(int i = 1; i <= BALLS; i++){
            int randomBall = getRandomBall(range);
            randomBalls.add(randomBall);
            range.remove(range.indexOf(randomBall));
        }

        return randomBalls;
    }

    @Override
    protected BallResult evaluateBall(int ball, int order, ArrayList<Integer> answer) {
        int ballIdx = answer.indexOf(ball);

        if (ballIdx == -1){
            return BallResult.NONE;
        }

        if (ballIdx == order){
            return BallResult.STRIKE;
        }
        else {
            return BallResult.BALL;
        }
    }

    @Override
    protected BallsResult evaluateBalls(ArrayList<Integer> guess, ArrayList<Integer> answer) {
        BallsResult ballsResult = new BallsResult();

        for(int i = 0; i < BALLS; i++){
            BallResult ballResult;
            ballResult = evaluateBall(guess.get(i), i, answer);

            ballsResult.addEarlyResult(ballResult);
        }
        return ballsResult;
    }

    @Override
    public void Run() {
        ArrayList<Integer> guess, computer;

        String input;
        boolean isEnd = false;

        computer = getRandomBalls();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            input = getLine();
            guess = stringToArrayList(input);

            BallsResult ballsResult = evaluateBalls(guess, computer);
            isEnd = ballsResult.printResults();

            if ( isEnd ) {
                break;
            }
        }
    }
}
