/*
 * Computer.java        2019/03/25
 *
 * Copyright (c) 2019 Yumin Kim.
 * All rights reserved.
 */

/**
 * Computer 클래스는 숫자야구게임에서 플레이어를 상대합니다.
 * 주 역할은 플레이어의 추측을 받아 자신의 정답과 비교하여 힌트를 주는 것입니다.
 *
 * @version       1.00 2019년 3월 25일
 * @author        김유민
 */
public class Computer {
    /** 컴퓨터의 정답이 저장되는 멤버변수입니다. */
    private int answer[];

    /** 컴퓨터가 숫자를 입력하라는 메세지를 콘솔에 출력하여 플레이어에게 전달합니다. */
    public void askNumbers() {
    }

    /** 플레이어의 추측과 자신의 정답을 비교하여 플레이어가 정답을 맞췄는지 아닌지를 알려줍니다. */
    public boolean checkGuess(int[] guess) {
    }

    /** 플레이어의 추측과 자신의 정답을 비교하여 힌트를 콘솔에 출력하여 플레이어에게 전달합니다. */
    public void giveHint(int[] guess) {
    }

    /** 플레이어에게 게임을 끝낼 것인지, 지속할 것인지를 묻는 메세지를 콘솔에 출력하여 플레이어에게 전달합니다. */
    public void askEnd() {
    }

    /** answer 멤버변수의 값을 초기화합니다. */
    public void initAnswer() {
    }
}
