package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        String playerNumber = inputPlayerNumber(scanner);

    }

    public static String inputPlayerNumber(Scanner scanner) {
        System.out.print("숫자를 입력해주세요 : ");
        String playerNumber = scanner.nextLine();

        return playerNumber;
    }
}
