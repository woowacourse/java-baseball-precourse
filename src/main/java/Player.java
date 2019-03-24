/*
 * Player.java        2019/03/25
 *
 * Copyright (c) 2019 Yumin Kim.
 * All rights reserved.
 */

/**
 * Player 클래스는 숫자야구게임의 유저를 대표합니다.
 * 주 역할은 정답을 알고 있는 컴퓨터를 상대로 숫자를 추측하는 것입니다.
 *
 * @version       1.00 2019년 3월 25일
 * @author        김유민
 */
public class Player {
    /** 플레이어의 추측이 저장되는 멤버변수입니다. */
    private int guess[];

    /** 플레이어가 컴퓨터를 상대로 정답을 추측하는 메소드입니다. 추측한 정답은 guess 멤버변수에 저장됩니다. */
    public void makeGuess() {
    }

    /** 플레이어가 클래스 외부로 자신의 추측을 알려주는 메소드입니다. */
    public int[] tellGuess() {
    }

    /** 플레이어가 자신이 게임을 지속하기를 원하는지 아닌지를 알려주는 메소드입니다. */
    public boolean wantToEnd() {
    }
}
