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

            String userNum = user.getNumber();
            String comNum = computer.getNumber();
            int strike = 0;
            int ball = 0;

            for (int i = 0; i < 3; i++) {

                if (comNum.charAt(i) == userNum.charAt(i)) {
                    strike++;
                } else if (comNum.contains(String.valueOf(userNum.charAt(i)))) {
                    ball++;
                }
            }

            StringBuilder sb = new StringBuilder();

            if (ball > 0) {
                sb.append(ball + "볼 ");
            }
            if (strike > 0) {
                sb.append(strike + "스트라이크");
            }
            if (strike == 0 && ball == 0) {
                sb.append("낫싱");
            }
            System.out.println(sb);

            break; // 테스트를 위한 break;
        }
    }
}
