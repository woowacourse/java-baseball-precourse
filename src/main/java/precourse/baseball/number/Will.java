/*
 * @(#)Will.java 2019/12/1
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

package precourse.baseball.number;

/**
 * @version     1.00 2019년 12월 1일
 * @author      임근원
 */
public enum Will {
    /* Will 이넘은 게임 플레이어가 게임을 다시 할 지 정할 때 쓰입니다. */

    WantToPlay(1),
    WantToStop(2);

    private int value;

    Will(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

