package me.bactoria.baseball;

import java.util.Scanner;

public interface UserInterface {

    Scanner scanner = new Scanner(System.in);

    static int getPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextInt();
    }

    static void printGameEnd() {
        System.out.println(Constant.NUMBER_OF_DIGITS + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    static void printHint(String hint) {
        System.out.println(hint);
    }
}
