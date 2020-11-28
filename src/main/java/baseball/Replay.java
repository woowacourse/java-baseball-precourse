package baseball;
import java.util.Scanner;

public class Replay {

    public static final String MSG_ASK_REST_OR_TERMINATE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final int INT_TO_REPLAY = 1;
    public static final int INT_TO_TERMINATE = 2;

    public static boolean doReplay(Scanner scanner) {
        Integer resetNumber;
        System.out.println(MSG_ASK_REST_OR_TERMINATE);
        while (scanner.hasNext()) {
            resetNumber = parseResetNumber(scanner.nextLine());
            if (resetNumber == INT_TO_REPLAY) {
                return true;
            }
            else if (resetNumber == INT_TO_TERMINATE) {
                return false;
            }
            System.out.println(MSG_ASK_REST_OR_TERMINATE);
        }
        return true;
    }
    private static Integer parseResetNumber(String number) {
        try {
            Integer intNumber = Integer.parseInt(number);
            if (intNumber == INT_TO_REPLAY || intNumber == INT_TO_TERMINATE) {
                return intNumber;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만을 입력해야 합니다");
        }
        return 0;
    }
}
