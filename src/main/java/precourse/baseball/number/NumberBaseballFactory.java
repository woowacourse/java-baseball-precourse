/*
 * @(#)NumberBaseballFactory.java 2019/12/1
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

package precourse.baseball.number;

import precourse.baseball.Baseball;
import precourse.baseball.BaseballFactory;
import precourse.baseball.Hitter;
import precourse.baseball.Pitcher;
import precourse.baseball.Referee;

/**
 * @version     1.00 2019년 12월 1일
 * @author      임근원
 */
public class NumberBaseballFactory implements BaseballFactory {
    /* NumberBaseballFactory는 숫자 야구 게임을 생성하는 역할을 합니다. */

    @Override
    public Baseball create(Hitter hitter, Pitcher pitcher, Referee referee) {
        return new NumberBaseball(hitter, pitcher, referee);
    }
}
