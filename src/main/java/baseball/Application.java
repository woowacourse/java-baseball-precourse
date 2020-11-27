package baseball;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        boolean gameOver = false;
        while (!gameOver) {
            System.out.print("숫자를 입력해주세요 : ");
            int[] guess = gameInput();

        }
    }

    private static int[] gameInput() {
        final Scanner scanner = new Scanner(System.in);
        int[] guess = new int[3];
        int input;
        try {
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("잘못된 입력값입니다.");
            throw new IllegalArgumentException();
        } catch (Exception e) {
            System.err.println("잘못된 입력값입니다.");
            throw new IllegalArgumentException();
        }

        if (input < 100 | input > 999) {
            System.err.println("잘못된 입력값입니다.");
            throw new IllegalArgumentException();
        }

        guess[0] = input / 100;
        guess[1] = (input / 10) % 10;
        guess[2] = input % 10;
        if (guess[1] == 0 || guess[2] == 0) {
            System.err.println("잘못된 입력값입니다.");
            throw new IllegalArgumentException();
        }
        System.out.printf("%d, %d, %d\n", guess[0], guess[1], guess[2]);
        return guess;
    }
}
