package baseball;

import java.util.Scanner;

public class BaseballGame {
    public static Computer computer;
    public static User user = new User();
    public static Scanner scanner = new Scanner(System.in);

    public static void startGame() {
        computer = new Computer();

        while (true) {
            try {
                System.out.print("숫자를 입력해주세요 : ");
                String input = scanner.nextLine();
                user.makeNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[잘못된 입력] 1에서 9사이의 서로 다른 숫자 3자리를 입력해주세요.");
                continue;
            }

            int strike = 0;
            int ball = 0;
            break;
        }
    }
}
