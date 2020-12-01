package baseball;

import baseball.service.Number;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        int[] randomNumber = Number.makeNumber();
        int input = 0;

        try {
            System.out.printf("숫자를 입력해주세요 : ");
            input = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("숫자가 아닙니다.");
        }

        try {
            Number.checkValidation(input);
        } catch (IllegalArgumentException e) {
            System.out.println("1에서 9까지 서로 다른 임의의 수 3개의 숫자를 공백없이 입력해 주세요.");
        }
    }
}
