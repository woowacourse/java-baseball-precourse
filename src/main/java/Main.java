/*
 * @(#)Main.java       0.2 2019/03/25
 */

/**
 * 숫자야구게임을 테스트하는 클래스
 *
 * @author 이도원
 * @version 0.2 2019/03/25
 */
public class Main {

    /**
     * 숫자야구게임을 실행하는 메소드
     *
     * @param args
     */
    public static void main(String[] args) {
        BaseballGame Game = new BaseballGame();
        Game.turnOn();
    }
}
