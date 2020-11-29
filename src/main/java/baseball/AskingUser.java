package baseball;

import utils.ValidatorUtils;
import java.util.Scanner;

public class AskingUser {

    private Scanner scanner;

    public AskingUser(Scanner scanner) {
        this.scanner = scanner;
    }

    public String askUserNumbers() {
        while (true) {
            System.out.print("숫자를 입력해 주세요 : ");
            String numbers = scanner.nextLine().trim();
            try {
                ValidatorUtils.checkNumbers(numbers);
                return numbers;
            } catch (IllegalArgumentException i) {
                System.out.println(i.getMessage());
            }
        }
    }


    public String askRestartOrExit() {
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String response = scanner.nextLine().trim();
            try {
                ValidatorUtils.checkResponse(response);
                return response;
            } catch (IllegalArgumentException i) {
                System.out.println(i.getMessage());
            }
        }
    }

}
