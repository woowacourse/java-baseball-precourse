package me.bactoria.baseball;

import java.util.Scanner;

public interface UserInterface {

    Scanner scanner = new Scanner(System.in);

    static int getPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextInt();
    }

    static void printHint(String hint) {
        System.out.println(hint);
    }
}
