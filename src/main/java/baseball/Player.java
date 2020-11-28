package baseball;

import java.util.Scanner;

public class Player {
    private Validator validator = new Validator();

    protected String playerInputNumber(Scanner scanner) {
        try {
            System.out.println("숫자를 입력해 주세요 : ");
            String playerInput = scanner.next();
            validator.isValidInputNumbers(playerInput);
//          System.out.println("inputData: " + playerInput);//확인
            return playerInput;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return playerInputNumber(scanner);
        }
    }

    protected int playerInputMenu(Scanner scanner) {
        try {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String menu = scanner.next();
            validator.isValidMenu(menu);
//          System.out.println("menu: " + menu);//확인
            return Integer.parseInt(menu);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return playerInputMenu(scanner);
        }
    }
}
