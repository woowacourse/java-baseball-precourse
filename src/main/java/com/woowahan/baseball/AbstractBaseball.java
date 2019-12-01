/*
 * AbstractBaseBall
 * 2019.11.30
 * Baseball 클래스 프로토타입
 */

package com.woowahan.baseball;

import java.util.ArrayList;

public abstract class AbstractBaseball {
    protected abstract Integer getRandomInteger(int min, int max);
    protected abstract String getLine();
    protected abstract ArrayList<Integer> stringToArrayList(String ballsString);

    protected final int BALLS = 3;

    protected abstract ArrayList<Integer> initializeBallRange();
    protected abstract Integer getRandomBall(ArrayList<Integer> range);
    protected abstract ArrayList<Integer> getRandomBalls();
    protected abstract EarlyResults.EarlyResult evaluateBall(int ball, int order,  ArrayList<Integer> balls);
    protected abstract EarlyResults evaluateBalls(ArrayList<Integer> user, ArrayList<Integer> answer);

    public abstract void Run();
}
