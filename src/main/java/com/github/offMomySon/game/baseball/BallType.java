/*
 * BallType
 *
 * @version 1
 *
 * @date 2019-3-28
 *
 * Copyright (c) 2019 Jihun oh.
 * All rights reserved.
 */
package com.github.offMomySon.game.baseball;

/**
 * @desc : BallType Class
 * 사용자의 입력값과 컴퓨터의 입력값을 비교한, Strike, Ball 개수를 인스턴스 변수로 가진다.
 * Strike, Ball 개수에 따라 toString() 메서드를 통해 사용자에게 게임의 결과를 String 형식으로 반환한다.
 * @pakage : com.github.offMomySon.game.baseball
 */
public class BallType {
    private int strike;
    private int ball;

    public BallType(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    /**
     * @return 스트라이크의 갯수와 볼의 갯수에 따라 힌트 String 을 리턴하는 메소드
     */
    @Override
    public String toString() {
        String string;

        if (strike == 0 && ball == 0)
            string = "낫싱";
        else if (strike != 0 && ball == 0)
            string = strike + " 스트라이크";
        else if (strike == 0 && ball != 0)
            string = ball + " 볼";
        else
            string = strike + " 스트라이크 " + ball + " 볼";

        return string;
    }
}
