package com.isbee.game.baseball;

/**
 * 야구 게임에 사용되는 method를 정의
 *
 * @author isbee
 * @version 1.0
 */
public interface BaseballGame {

    /** 게임 진행 */
    void play();

    /**
     * 플레이어의 숫자를 받아서 리턴
     *
     * @return 입력 숫자
     */
    int getUserNum();

    /**
     * 1~9 사이의 중복없는 난수로 이루어진 수를 생성하여 리턴
     *
     * @return 플레이어가 맞춰야 할 난수
     */
    int generateRandomNum();

    /**
     * 생성된 난수와 플레이어의 입력 숫자를 비교한 결과를 리턴
     *
     * @return 3 스트라이크 성공 여부
     */
    boolean compareNum();
}