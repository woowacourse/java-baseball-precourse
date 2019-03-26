package com.woowa.baseball;


/**
 * 게임 기능 정의
 *
 * @version     1.0
 * @since       03/25/2019
 * @author      icarus8050
 */
public interface Game {

    /**
     * 게임을 실행시키는 메서드
     * @return  true 반환 시, 재실행
     *           false 반환 시, 종료
     */
    public boolean run();

    /**
     * 게임 종료 전, 실행되는 메서드
     */
    public void exit();
}
