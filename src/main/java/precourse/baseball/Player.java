/*
 * @(#)Player.java 2019/12/1
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

package precourse.baseball;

/**
 * @version     1.00 2019년 12월 1일
 * @author      임근원
 */
public interface Player {
    /* Player 인터페이스는 '타자', '투수' 등 경기에 참여하는 선수라면 반드시 가져야 할 함수를 명시합니다. */

    /** 게임이 종료될 시, 다시 게임을 할 지 선택하는 기능입니다. */
    boolean wantToPlayAgain();
}
