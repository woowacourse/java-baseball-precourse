/*
 * 클래스 이름 : GameResult
 *
 * 버전 정보 : v 0.0.4
 *
 * 날짜 : 2019-03-27
 *
 * Copyright 2019 KwonMC
 */
package com.kwonmc.baseball;

/**
 * 게임 결과인 strike 와 ball 을 저장하고 이 둘과 관련된 메서드가 있는 클래스
 *
 * @version 0.0.4
 * @author kwonmc
 */
public class GameResult {
    private static int INT_ZERO = 0;
    private static int INT_ONE = 1;
    private static int STRIKE_THREE = 3;

    private int strike;
    private int ball;

    /**
     * com.kwonmc.baseball.GameResult 생성자
     * 인스턴스 생성시 strike 와 ball 은 0 으로 초기화
     */
    public GameResult() {
        this.strike = INT_ZERO;
        this.ball = INT_ZERO;
    }

    /**
     * Strike 가 있을 때 com.kwonmc.baseball.GameResult 인스턴스의 strike 를 1 증가시키는 메서드
     */
    public void oneMoreStrike() {
        this.strike += INT_ONE;
    }

    /**
     * Ball 이 있을 때 com.kwonmc.baseball.GameResult 인스턴스의 ball 을 1 증가시키는 메서드
     */
    public void oneMoreBall() {
        this.ball += INT_ONE;
    }

    /**
     * com.kwonmc.baseball.GameResult 인스턴스를 초기상태로 되돌리기 위한 메서드
     */
    public void initGameResult() {
        this.strike = INT_ZERO;
        this.ball   = INT_ZERO;
    }

    /**
     * com.kwonmc.baseball.GameResult 인스턴스의 strike 가 3이면 게임이 끝나므로 이를 검사하는 메서드
     * @return strike 가 3일때 true
     */
    public boolean isEnd() {
        return (this.strike == STRIKE_THREE);
    }

    /**
     * this.strike 와 this.ball 의 값에 따라 결과를 콘솔에 출력하는 메서드
     */
    public void print() {
        if (this.strike == INT_ZERO && this.ball == INT_ZERO) {
            System.out.println("포볼");

        } else if (this.strike == INT_ZERO) {
            System.out.printf("%d 볼\n", this.ball);

        } else if (this.ball == INT_ZERO) {
            System.out.printf("%d 스트라이크\n", this.strike);
            printSuccess();

        } else {
            System.out.printf("%d 스트라이크 %d 볼\n", this.strike, this.ball);
        }
    }

    public void printSuccess() {
        if (this.strike == STRIKE_THREE) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
