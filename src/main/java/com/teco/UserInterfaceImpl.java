package com.teco;

import java.util.Scanner;

public class UserInterfaceImpl implements UserInterface {
    private static final int USER_INPUT_SIZE = 3;
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public String[] getUserRandomNumber() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String[] userInputArr = SCANNER.nextLine().replaceAll(" ", "").split("");
        if (userInputArr.length != USER_INPUT_SIZE) {
            throw new IllegalArgumentException("3자리의 숫자를 입력해주세요.");
        }
        return userInputArr;
    }

    @Override
    public void printResult(String result) {
        System.out.println(result);
    }

    @Override
    public void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Override
    public String checkEndOrNot() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return SCANNER.nextLine();
    }
}
