/*
 * InputView.java
 *
 * version 1.0
 *
 * 2020/11/27
 *
 * Copyright (c) 2020 Junhyoung Park
 */

package baseball.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String PLAY_OR_NOT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ";

    public static String inputPlayerNumber(Scanner scanner) {
        System.out.print(INPUT_MESSAGE);
        return scanner.next();
    }

    public static int inputPlayOrNotNumber(Scanner scanner) {
        System.out.println(PLAY_OR_NOT_MESSAGE);
        return scanner.nextInt();
    }
}
