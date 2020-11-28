package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        Validator validator = new Validator();
        GameManager manager = new GameManager();

        while (manager.isGameInProgress()) {
            System.out.print("숫자를 입력해주세요 : ");

            String inputValue = scanner.nextLine();

            validator.validateInputValue(inputValue);

            System.out.println(inputValue);
        }
    }
}
