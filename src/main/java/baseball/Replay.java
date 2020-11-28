package baseball;
import java.util.Scanner;

public class Replay {
    public static boolean doReplay(Scanner scanner) {
        Integer resetNumber;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        while (scanner.hasNext()) {
            resetNumber = parseResetNumber(scanner.nextLine());
            if (resetNumber == 1) {
                return true;
            }
            else if (resetNumber == 2) {
                return false;
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
        return true;
    }
    private static Integer parseResetNumber(String number) {
        try {
            Integer intNumber = Integer.parseInt(number);
            if (intNumber == 1 || intNumber == 2) {
                return intNumber;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만을 입력해야 합니다");
        }
        return 0;
    }
}
