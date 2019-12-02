/*
 * @(#)Result.java
 *
 * v 0.0.0
 *
 * 2019.12.02
 *
 * Copyright 2019. DunDung all rights reserved.
 */
public class Result {
    private static final int COMPARE_VALUE = 0;
    private int strike;
    private int ball;

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();

        if (strike == NumberBaseBallGame.DIGIT) {
            return NumberBaseBallGame.DIGIT + "개의 숫자를 모두 맞히셨습니다! 게임종료" ;
        }
        if (strike > COMPARE_VALUE) {
            builder.append(strike + " 스트라이크 ");
        }
        if (ball > COMPARE_VALUE) {
            builder.append(ball + "볼");
        }
        if (builder.length() == COMPARE_VALUE) {
            builder.append("낫싱") ;
        }

        return builder.toString();
    }

    public int getStrike() {
        return strike;
    }
}
