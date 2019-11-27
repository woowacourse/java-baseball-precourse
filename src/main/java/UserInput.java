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
