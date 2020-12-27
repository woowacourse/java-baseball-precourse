package baseball;

import utils.IntegerUtils;

import java.util.Scanner;

public class BaseballIO {
    private Scanner scanner;

    public BaseballIO(Scanner scanner) {
        this.scanner = scanner;
    }

    public int[] getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = scanner.next();
        if (!IntegerUtils.isInteger(input)) {
            throw new IllegalArgumentException();
        }
        int[] res = input.chars().map(n -> n-'0').toArray();
        if (res.length != 3) {
            throw new IllegalArgumentException();
        }
        return res;
    }

    public void printResult(int result[]) {
        int ball = result[0];
        int strike = result[1];
        if (ball > 0) {
            System.out.print(ball+"볼");
        }
        if (strike > 0) {
            System.out.print(strike+"스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public boolean willRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int input = scanner.nextInt();
        if (input == 1) {
            return true;
        }
        else if (input == 2) {
            return false;
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}
