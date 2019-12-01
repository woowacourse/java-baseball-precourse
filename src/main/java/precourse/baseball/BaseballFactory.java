/*
 * @(#)BasballFactory.java 2019/12/1
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

package precourse.baseball;

/**
 * @version     1.00 2019년 12월 1일
 * @author      임근원
 */
public interface BaseballFactory {
    /* BaseballFactory 인터페이스는 야구 게임을 생성하기 위한 함수를 명시합니다. */

    Baseball create(Hitter hitter, Pitcher pitcher, Referee referee);
}
