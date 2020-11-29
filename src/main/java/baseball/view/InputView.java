/*
 * InputView.java            0.9       2020-11-25
 *
 * Copyright (c) 2020 Yeonwoo Cho
 * ComputerScience, ProgrammingLanguage, Java, Seoul, KOREA
 * All rights reserved
 */

package baseball.view;

import java.util.Scanner;

/**
 * 입력을 담당하는 클래스
 *
 * @author 조연우
 * @version 1.0 2020년 11월 25일
 */
public class InputView {

    public static String receiveInputNumbers(Scanner scanner) {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextLine();
    }

    public static String receiveRestartNumber(Scanner scanner) {
        return scanner.nextLine();
    }
}
