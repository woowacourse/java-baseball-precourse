package baseball;

import java.util.Scanner;

public class Restart {

    public static boolean isRestart(Scanner scanner) {
        boolean restart = false;
        String answer = restartInput(scanner);

        if (answer.equals("1")) {
            restart = true;
        }

        if (answer.equals("2")) {
            restart = false;
        }

        if (!answer.equals("1") && !answer.equals("2")) {
            throw new IllegalArgumentException("1과 2만 입력가능합니다!");
        }

        return restart;
    }

    static String restartInput(Scanner scanner) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.next();
    }
}
