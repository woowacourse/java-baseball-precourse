package baseballgame.io;

import java.util.Scanner;

public class InputBaseballGame {
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
        if (userNumber < 99 || userNumber > 999)
            throw new IllegalStateException("세 자리의 정수만 입력할 수 있습니다.");
        return userNumber;
    }

    public static int validateNextStep(int nextStep) {
        if (nextStep != 1 && nextStep != 2)
            throw new IllegalStateException("'1', '2'만 입력할 수 있습니다.");
        return nextStep;
    }
}
