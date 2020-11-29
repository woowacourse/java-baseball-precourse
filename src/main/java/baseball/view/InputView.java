package baseball.view;

import java.util.Scanner;

public class InputView {
    private static final String ASK_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String GET_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RETYPE_AGAIN = "값을 입력해주세요";

    private static Scanner scanner;
    // input에 사용될 Scanner 객체를 설정한다.
    public static void setScanner(Scanner scanner){
        InputView.scanner = scanner;
    }

    public static String getNumbers(){
        System.out.print(GET_NUMBERS_MESSAGE);
        String userInput = deleteWhiteSpaces(scanner.nextLine());
        if (userInput.equals("")){
            System.out.println(RETYPE_AGAIN);
            getNumbers();
        }
        return userInput;
    }

    public static String getRestartChoice(){
        System.out.println(ASK_RESTART_MESSAGE);
        String userInput = deleteWhiteSpaces(scanner.nextLine());
        if (userInput.equals("")){
            System.out.println(RETYPE_AGAIN);
            getRestartChoice();
        }
        return userInput;
    }

    private static String deleteWhiteSpaces(String string){
        return string.replaceAll("\\s+", "");
    }
}
