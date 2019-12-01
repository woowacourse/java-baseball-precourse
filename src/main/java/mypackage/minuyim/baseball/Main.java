/*
 * @(#)Main.java
 * 
 * version : 1.0
 * 
 * 2019.12.01
 */

package mypackage.minuyim.baseball;

import mypackage.minuyim.baseball.MainGame;

/**
 * Main : 숫자 야구 게임을 시작하는 클래스
 * 
 * @version 1.00 2019/12/01
 * @author 임민우
 */
public class Main {
    public static void main(String[] args) {
        MainGame game = new MainGame();
        game.start();

        return;
    }

}