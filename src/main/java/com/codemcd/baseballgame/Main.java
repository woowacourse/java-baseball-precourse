package com.codemcd.baseballgame;

public class Main {

    public static void main(String[] args) {

        NumberBaseball newGame = new NumberBaseball();
        newGame.makeRandomNumber();
        newGame.inputUserNumber();
        newGame.matchUserAndComputer();
        newGame.printMatchResult();
        newGame.isContinue();

        System.out.println("게임이 종료되었습니다.");

    }
}
