package indi.moon.firstweek;

/*
 * 숫자야구 인터페이스
 * @date        2019-03-23
 * @author      문지원
 * @version 1.0.0
 */

public interface Indexface {

    /**
     *  게임을 시작하는 메소드
     *  시작시 아무키나 누르고, 종료시에 exit()을 입력
     */
    public abstract String start();

    /** 게임을 종료하는 메소드 */
    public abstract void end();

}