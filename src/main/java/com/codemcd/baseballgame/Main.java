/*
 * @(#)Main.java
 * v1.00
 * 2019/03/27
 */

package com.codemcd.baseballgame;

/**
 * 숫자 야구 게임을 진행하는 Main 클래스
 *
 * @version v1.00
 * @author 박성범
 */
public class Main {

    private static boolean bGameStart = true;
    private static boolean bGameEnd;

    public static void main(String[] args) {

        NumberBaseball baseballGame = new NumberBaseball();

        while (bGameStart) {

            /* 게임을 새로 시작할 때마다 bGameEnd 를 false 로 초기화해야 한다. */
            bGameEnd = false;

            baseballGame.initialize();
            baseballGame.makeRandomNumber();

            while (!bGameEnd) {
                baseballGame.inputUserNumber();
                bGameEnd = baseballGame.matchUserAndComputer();
                baseballGame.printMatchResult();
            }

            bGameStart = baseballGame.isContinue();
        }

        System.out.println("게임이 종료되었습니다.");

    }

}
