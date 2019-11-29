package baseballgame.io;

import java.util.Scanner;

public class InputBaseballGame {
    private static Scanner sc = new Scanner(System.in);

    public static int inputUserNumber() {
        // TODO: 2019-11-28 세자리 숫자 이외의 입력 예외처리 
        System.out.println("숫자를 입력해주세요 : ");
        return sc.nextInt();
    }

    public static int inputNextStep() {
        // TODO: 2019-11-28 1, 2 이외의 입력 예외처리
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return sc.nextInt();
    }
}
