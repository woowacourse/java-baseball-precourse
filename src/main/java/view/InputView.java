package view;

import java.util.Scanner;

public class InputView {
    private static final String ASK_NUMBER_MSG = "숫자를 입력해주세요 : ";
    private static final String ASK_PLAY_AGAIN = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String askGuessNum(Scanner SCANNER){
        System.out.println(ASK_NUMBER_MSG);
        return readInputLine(SCANNER);
    }

    public static String askPlayAgain(Scanner SCANNER){
        System.out.println(ASK_PLAY_AGAIN);
        return readInputLine(SCANNER);
    }

    private static String readInputLine(Scanner SCANNER){
        return SCANNER.nextLine();
    }
}
