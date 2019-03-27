package com.codemcd.baseballgame;

public class Main {

    private static boolean bGameStart = true;
    private static boolean bGameEnd;

    public static void main(String[] args) {

        while (bGameStart) {

            /* 게임을 새로 시작할 때마다 bGameEnd 를 false 로 초기화해야 한다. */
            bGameEnd = false;
            NumberBaseball newGame = new NumberBaseball();
            newGame.makeRandomNumber();

            while (!bGameEnd) {
                newGame.inputUserNumber();
                bGameEnd = newGame.matchUserAndComputer();
                newGame.printMatchResult();
            }

            bGameStart = newGame.isContinue();
        }

        System.out.println("게임이 종료되었습니다.");

    }
}
