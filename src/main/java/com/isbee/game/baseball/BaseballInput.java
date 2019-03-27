package com.isbee.game.baseball;

/**
 * 야구 게임 플레이어의 입력을 처리하는 method를 정의
 *
 * @author isbee
 * @version 1.0
 */
public interface BaseballInput {

    /**
     * 플레이어의 숫자를 받아서 리턴
     *
     * @return 입력 숫자
     */
    int getUserNum();

    /**
     * 플레이어로부터 재시작 여부를 입력 받은 뒤, 해당 숫자 리턴
     *
     * @return 재시작 여부를 나타내는 숫자
     */
    int getWhetherRestart();

    /**
     * getWhetherRestart로 받은 숫자를 Enum의 숫자와 비교한 결과를 리턴
     *
     * @return 재시작 여부
     */
    boolean playMoreOrNot();
}