/*
 * Inputview.java
 * java-baseball-precourse
 *
 * Version 0.3
 *
 * Created by 김경준 on 27/11/2019.
 *
 * Copyright © 2019 kouz95. All rights reserved.
 */

package view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String NEW_GAME_OR_QUIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String getUserString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public static int getNewGameOrQuitNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(NEW_GAME_OR_QUIT_MESSAGE);
        return scanner.nextInt();
    }
}
