/*
 * @(#)NumberBaseball.java 2019/12/1
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

package precourse.baseball.number;

import precourse.baseball.Baseball;
import precourse.baseball.Hitter;
import precourse.baseball.Pitcher;
import precourse.baseball.Referee;
import precourse.baseball.Result;

import java.util.List;

/**
 * @version     1.00 2019년 12월 1일
 * @author      임근원
 */
public class NumberBaseball implements Baseball {
    /* NumberBaseball은 숫자 야구 게임을 의미합니다. */

    private Hitter hitter;
    private Pitcher pitcher;
    private Referee referee;

    NumberBaseball(Hitter hitter, Pitcher pitcher, Referee referee) {
        this.hitter = hitter;
        this.pitcher = pitcher;
        this.referee = referee;
    }

    /** 숫자 야구 게임은 일반적인 야구와 다르게, 타자가 먼저 칠 방향을 정하고,
     * 투수가 타자의 방향을 전부 맞힐 때까지 던지고, 심판이 판정 및 결과 발표하는 순서로 진행됩니다.*/
    @Override
    public void play() {
        Result result = start();
        List<Integer> ballsHit = hitter.hit();
        while (!isStrikeOut(result)) {
            List<Integer> ballsPitched = pitcher.pitch();
            result = referee.judge(ballsHit, ballsPitched);
            referee.announce(result);
        }

        if (pitcher.wantToPlayAgain()){
            play();
            return;
        }
        finish();
    }
    private Result start() {
        return new Result(NumberBaseballConfig.DEFAULT_VALUE, NumberBaseballConfig.DEFAULT_VALUE);
    }
    private boolean isStrikeOut(Result result) {
        return result.getStrikes() == NumberBaseballConfig.ROUND && result.getB() == NumberBaseballConfig.DEFAULT_VALUE;
    }
    private void finish() {
        System.out.println("게임이 완전히 종료되었습니다.");
    }

}
