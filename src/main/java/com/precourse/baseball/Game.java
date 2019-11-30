/*
 * Game.java                       1.3.0   2019-11-30
 *
 * Copyright (c) 2019 Hyungju An.
 * All rights reserved.
 * Contact me for more information. a301dks@naver.com
 */

package com.precourse.baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 게임 클래스입니다.
 * 숫자 야구 게임을 진행하는 메인 클래스입니다.
 * 상대방(컴퓨터)가 생각한 수를 사용자가 예측하는 방식으로 진행,
 * 게임이 끝나면 게임 재시작을 하거나, 게임을 완전히 종료한다.
 *
 * @author HyungjuAn
 * @version 1.3.0       잘못 입력된 재시작 정보를 알려주는 기능
 * @date 2019-11-30
 */
public class Game {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Player computer = new Player();
        Player user = new Player();


    }

    public static void startGame(Player computer, Player user) throws IOException {
        do {

        } while (isRestart());
    }

    public static boolean isRestart() throws IOException {
        boolean result;
        int restartInfo = InputRestartInfo();

        if (restartInfo == 1) {
            result = true;
        } else if (restartInfo == 2) {
            result = false;
        } else {
            printWrongInputMessage();
            result = isRestart();
        }

        return result;
    }

    public static int InputRestartInfo() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int restartInfo;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        restartInfo = Integer.parseInt(br.readLine());

        return restartInfo;
    }

    public static void printWrongInputMessage() {
        System.out.println("ERROR! 잘못된 입력입니다!");
    }
}
