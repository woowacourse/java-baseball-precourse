package baseball.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_USER_NUMBER_MENT = "숫자를 입력해주세요 : ";
    private static final String CONTINUE_ASK_MENT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String getNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(INPUT_USER_NUMBER_MENT);
        return scanner.nextLine();
    }

    public static int continueNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(CONTINUE_ASK_MENT);
        return scanner.nextInt();
    }
}
