package baseball;

import java.util.Scanner;

public class BaseballGame {
    public static Computer computer;
    public static User user;

    public static void startGame(Scanner scanner) {
        computer = new Computer();

        while (true) {
            try {
                user.makeNumber(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println("1에서 9사이의 서로 다른 숫자 3자리를 입력해주세요.");
                continue;
            }

            int strike = 0;
            int ball = 0;

        }
    }
}
