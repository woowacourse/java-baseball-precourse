package com.kwonmc.baseball;

import java.util.Scanner;

/*
 * 클래스 이름 : Game
 *
 * 버전 정보 : v 0.0.4
 *
 * 날짜 : 2019-03-27
 *
 * Copyright 2019 KwonMC
 */
public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GamePlay gamePlay = new GamePlay();

        while (gamePlay.isContinueGame()) {
            gamePlay.init();
            gamePlay.requestInputMessage();
            gamePlay.getUserInput(sc);
            gamePlay.countResult();
            gamePlay.getGameResult().print();
            gamePlay.getUserEndOrContinue(sc);
            gamePlay.getGameResult().initGameResult();
        }
    }
}
