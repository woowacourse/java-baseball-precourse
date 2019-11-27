import java.util.Scanner;

public class UserInput {
    private Scanner scanner;

    public UserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getUserNumber() {
        while (true) {
            System.out.print("숫자를 입력해주세요: ");
            String number = this.scanner.nextLine();
            if (isCorrectlyFormatted(number)) {
                return number;
            }
        }
    }

    public boolean isRestartingGame() {
        while (true) {
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            String choice = this.scanner.nextLine();
            if (choice.equals("1")) {
                return true;
            } else if (choice.equals("2")) {
                return false;
            }
        }
    }

    private boolean isCorrectlyFormatted(String number) {
        if (number == null || number.length() != 3) {
            return false;
        }
        try {
            int parsedNum = Integer.parseInt(number);
            if (parsedNum > 999 || parsedNum < 111) {
                return false;
            }
        } catch (NumberFormatException error) {
            return false;
        }
        return true;
    }
}
