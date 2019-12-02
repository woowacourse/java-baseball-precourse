package com.woowacourse.baseballgame.io;

import java.util.Scanner;

import static com.woowacourse.baseballgame.system.BaseballGameSystem.CONTINUE;
import static com.woowacourse.baseballgame.system.BaseballGameSystem.GAMEOVER;

public class InputBaseballGame {
    private static final int MIN_NUM = 111;
    private static final int MAX_NUM = 999;

    private static Scanner sc = new Scanner(System.in);

    public static int inputUserNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        return validateUserNumber(sc.nextInt());
    }

    public static int inputNextStep() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return validateNextStep(sc.nextInt());
    }

    public static int validateUserNumber(int userNumber) {
        if (userNumber < MIN_NUM || userNumber > MAX_NUM)
            throw new IllegalStateException("111 ~ 999 정수만 입력할 수 있습니다.");
        return userNumber;
    }

    public static int validateNextStep(int nextStep) {
        if (nextStep != CONTINUE && nextStep != GAMEOVER)
            throw new IllegalStateException("'1', '2'만 입력할 수 있습니다.");
        return nextStep;
    }
}
