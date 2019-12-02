/*
 * Game.java                       1.6.3   2019-12-02
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
 * @version 1.6.3                       toString method override
 * @date 2019-12-02
 */
public class Game {
    private static final String THREE_STRIKE = "3 스트라이크";

    public static void main(String[] args) throws IOException {
        Player computer = new Player();
        Player user = new Player();

        startGame(computer, user);
    }

    public static void startGame(Player computer, Player user) throws IOException {
        String hint;

        computer.setRandomNumbers();
        do {
            user.readNumbers();

            hint = computer.giveHintAboutNumbers(user.getDigitNumbers());
            printHint(hint);
        } while (!hint.equals(THREE_STRIKE));
        printGameFinishMessage();

        if (isRestart()) {
            startGame(computer, user);
        }
    }

    private static void printHint(String hint) {
        System.out.println(hint);
    }

    private static void printGameFinishMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static boolean isRestart() throws IOException {
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

    private static int InputRestartInfo() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int restartInfo;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        restartInfo = Integer.parseInt(br.readLine());

        return restartInfo;
    }

    private static void printWrongInputMessage() {
        System.out.println("ERROR! 잘못된 입력입니다!");
    }

    @Override
    protected final void finalize() throws Throwable {
        // do nothing
    }

    @Override
    public String toString() {
        return Game.class.getName();
    }
}
