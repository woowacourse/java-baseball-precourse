package baseball;

import java.util.InputMismatchException;
import java.util.Scanner;
import utils.RandomUtils;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        boolean gameOver = false;
        while (!gameOver) {
            int[] choice = new int[3];
            // for all different
            while (choice[0] == choice[1] | choice[1] == choice[2] | choice[0] == choice[2]) {
                choice[0] = RandomUtils.nextInt(1, 9);
                choice[1] = RandomUtils.nextInt(1, 9);
                choice[2] = RandomUtils.nextInt(1, 9);
            }
            gameStart(choice);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameOver = gameRestartInput();
        }
    }

    private static int[] gameInput() {
        final Scanner scanner = new Scanner(System.in);
        int[] guess = new int[3];
        int input;
        try {
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("잘못된 입력값입니다. 1부터 9까지 서로 다른 3가지 숫자를 입력해주세요. ");
            throw new IllegalArgumentException();
        } catch (Exception e) {
            System.err.println("잘못된 입력값입니다. 1부터 9까지 서로 다른 3가지 숫자를 입력해주세요. ");
            throw new IllegalArgumentException();
        }

        if (input < 100 | input > 999) {
            System.err.println("잘못된 입력값입니다. 1부터 9까지 서로 다른 3가지 숫자를 입력해주세요. ");
            throw new IllegalArgumentException();
        }

        guess[0] = input / 100;
        guess[1] = (input / 10) % 10;
        guess[2] = input % 10;
        if (guess[1] == 0 || guess[2] == 0) {
            System.err.println("잘못된 입력값입니다. 1부터 9까지 서로 다른 3가지 숫자를 입력해주세요. ");
            throw new IllegalArgumentException();
        }
        return guess;
    }

    private static void gameStart(int[] choice) {
        boolean success = false;

        while (!success) {
            System.out.print("숫자를 입력해주세요 : ");
            success = hintAndSuccessDecide(gameInput(), choice);
        }
    }

    private static boolean hintAndSuccessDecide(int[] guess, int[] choice) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (guess[i] == choice[i]) {
                strike++;
                continue;
            }
            if (guess[i] == choice[(i + 1) % 3] | guess[i] == choice[(i - 1 + 3) % 3]) {
                ball++;
            }
        }
        if (ball > 0) {
            if (strike > 0) {
                System.out.printf("%d볼 %d스트라이크\n", ball, strike);
            } else {
                System.out.printf("%d볼\n", ball);
            }
        } else {
            if (strike > 0) {
                System.out.printf("%d스트라이크\n", strike);
            } else {
                System.out.println("낫싱");
            }
        }

        return strike == 3;
    }

    private static boolean gameRestartInput() {
        final Scanner scanner = new Scanner(System.in);
        int input;
        try {
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("잘못된 입력값입니다. 1이나 2를 입력해 주세요. ");
            throw new IllegalArgumentException();
        } catch (Exception e) {
            System.err.println("잘못된 입력값입니다. 1이나 2를 입력해 주세요. ");
            throw new IllegalArgumentException();
        }

        switch (input) {
            case 1:
                return false;
            case 2:
                return true;
            default:
                System.err.println("잘못된 입력값입니다. 1이나 2를 입력해 주세요. ");
                throw new IllegalArgumentException();
        }
    }
}
