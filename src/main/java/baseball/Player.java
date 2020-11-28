package baseball;

import java.util.Scanner;

public class Player {
    private Validator validator = new Validator();

    protected String playerInputNumbers(Scanner scanner) {
        try {
            System.out.println("숫자를 입력해 주세요 : ");
            String playerInput = scanner.next();
            validator.isValidInputNumbers(playerInput);
            return playerInput;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return playerInputNumbers(scanner);
        }
    }

    protected int playerInputMenu(Scanner scanner) {
        try {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String gameStatus = scanner.next();
            validator.isValidMenu(gameStatus);
            return Integer.parseInt(gameStatus);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return playerInputMenu(scanner);
        }
    }
}
