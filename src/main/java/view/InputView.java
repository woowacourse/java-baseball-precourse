/*
 * Inputview.java
 * java-baseball-precourse
 *
 * Version 0.1
 *
 * Created by 김경준 on 27/11/2019.
 *
 * Copyright © 2019 kouz95. All rights reserved.
 */

package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public static String getUserString() {
        System.out.println(INPUT_MESSAGE);
        return scanner.nextLine();
    }
}
