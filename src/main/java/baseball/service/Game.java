package baseball.service;

import java.util.Scanner;

public class Game {

    private Game() {
    }

    public static void playGame() {
        final Scanner scanner = new Scanner(System.in);
        int[] inputNumber;
        int strikeCnt = 0;

        int[] randomNumber = Number.makeNumber();

        while (strikeCnt < 3) {
            try {
                System.out.printf("숫자를 입력해주세요 : ");
                String input = scanner.nextLine();
                inputNumber = Number.checkValidation(Integer.parseInt(input));
            } catch (IllegalArgumentException e) {
                System.out.println(
                    "1에서 9까지 서로 다른 임의의 수 " + Number.NUMBER_LENGTH + "개의 숫자를 공백없이 입력해 주세요.");
                continue;
            }

            strikeCnt = Number.printHint(randomNumber, inputNumber);
        }
    }

    public static int checkStatus(String status) {
        int gameStatus;
        try {
            gameStatus = Integer.parseInt(status);
            if (gameStatus != 1 && gameStatus != 2) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못 입력하셨습니다.");
            return 0;
        }

        return gameStatus;
    }
}
