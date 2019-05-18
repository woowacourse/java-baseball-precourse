package com.teco;

/**
 * strike, ball만 멤버로 가지는 데이터 구조의 형태만 가지는 클래스
 */
public class StrikeBall {
    private int strike;
    private int ball;

    StrikeBall(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    void setBall(int ball) {
        this.ball = ball;
    }

    void setStrike(int strike) {
        this.strike = strike;
    }

    int getBall() {
        return ball;
    }

    int getStrike() {
        return strike;
    }
}
