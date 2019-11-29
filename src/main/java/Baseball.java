import java.util.Scanner;

public class Baseball {
    private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_MENU_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    private static int[] inputNumbers() {
        try {
            System.out.print(INPUT_NUMBERS_MESSAGE);
            return User.readNumbers(SCANNER.next());
        } catch (Exception e) {
            return inputNumbers();
        }
    }

    private static int inputMenu() {
        try {
            System.out.println(INPUT_MENU_MESSAGE);
            return User.readMenu(SCANNER.nextInt());
        } catch (Exception e) {
            return inputMenu();
        }
    }
}
