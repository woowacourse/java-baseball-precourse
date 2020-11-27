package baseball;

import baseball.controller.GameController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        // 플레이어가 3자리 수를 입력한다.
        do {
            System.out.println("숫자를 입력해주세요 : ");
            String scannerNumber = scanner.nextLine();
            String result = GameController.scanPlayerNumber(scannerNumber);
            System.out.println(result);
        } while (GameController.continueGame());
    }
}
