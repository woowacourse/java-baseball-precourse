/**
 * InputView.java
 * 입력과 출력이 섞인 로직을 담당하는 View 클래스
 *
 * @author Kimun Kim / kkm97351@gmail.com
 */

package baseball.view;

import java.util.Scanner;

public class InputView {
    private static final String ASK_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    private static final String GET_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RETYPE_AGAIN = "값을 입력해주세요";

    private static Scanner scanner;

    /* 입력에 사용될 Scanner 객체를 받아 설정 */
    public static void setScanner(Scanner scanner) {
        InputView.scanner = scanner;
    }

    /* 숫자 입력을 요구하는 메소드 */
    public static String getNumbers() {
        return getInputWithMessage(GET_NUMBERS_MESSAGE);
    }

    /* 재시작을 묻고 값을 받아 리턴하는 메소드 */
    public static String getRestartChoice() {
        return getInputWithMessage(ASK_RESTART_MESSAGE);
    }

    /* 파라미터로 받은 메세지를 출력하고 입력을 요구하며, 공백 입력에 대해 재입력을 요구합니다. */
    public static String getInputWithMessage(String msg) {
        System.out.print(msg);
        String userInput = deleteWhiteSpaces(scanner.nextLine());
        if (!userInput.equals("")) {
            return userInput;
        }
        System.out.println(RETYPE_AGAIN);
        return getInputWithMessage(msg);

    }

    /* 입력값에 존재하는 모든 공백을 제거 */
    private static String deleteWhiteSpaces(String string) {
        return string.replaceAll("\\s+", "");
    }
}
