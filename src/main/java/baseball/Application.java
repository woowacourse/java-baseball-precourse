package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        while (true) {
            BaseballGame.startGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int inputNum = 0;

            while (inputNum != 1 && inputNum != 2) {
                inputNum = scanner.nextInt();

                if (inputNum != 1 && inputNum != 2) {
                    System.out.println("[잘못된 입력]게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                }
            }

            if (inputNum == 2) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}
