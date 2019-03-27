package com.nekisse.baseball;

import java.util.Scanner;

public class InputView {
    public static String printMenu() {
        System.out.print("숫자를 입력해주세요  :");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
