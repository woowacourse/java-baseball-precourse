/*
 * @(#)Referee.java 2019/12/1
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

package precourse.baseball;

import java.util.List;

/**
 * @version     1.00 2019년 12월 1일
 * @author      임근원
 */
public interface Referee {
    /* Referee 인터페이스는 '심판'의 역할을 수행합니다. 스트라이크 혹은 볼이 몇 개인지 '판단'하고, 그것을 '발표'합니다. */

    Result judge(List<Integer> ballsPitched, List<Integer> ballsHit);
    void announce(Result result);
}
