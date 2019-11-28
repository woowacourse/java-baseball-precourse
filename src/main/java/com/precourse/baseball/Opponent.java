package com.precourse.baseball;

/**
 * Opponent.class
 * 상대방(컴퓨터) 클래스입니다.
 * 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 랜덤하게 만들고
 * 플레이어가 예측에 틀릴 경우 힌트를 줍니다.
 *
 * @author HyungjuAn
 * @version 1.0
 * @date 2019-11-28
 */
public class Opponent {
    private boolean[] mask;
    private int[] threeDigitNumber;

    public Opponent() {
        this.mask = new boolean[10];
        this.threeDigitNumber = new int[3];
    }
}
