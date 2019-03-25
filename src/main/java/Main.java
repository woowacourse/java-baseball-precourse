/*
 * @(#)Main.java        0.3 2019/03/26
 *
 *
 */

import baseballgame.BaseballGame;

/**
 * BaseballGame 실행을 위한 Main클래스 입니다.
 *
 * @version         0.3 2019년 3월 26일
 * @author          반선호
 */
public class Main {
    public static void main(String[] args){
        BaseballGame game = new BaseballGame();
        game.run();
    }
}
