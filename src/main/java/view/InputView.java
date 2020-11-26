package view;

import java.util.Scanner;

public class InputView {
    private static final String ASK_NUMBER_MSG = "숫자를 입력해주세요 : ";
    private static final String ASK_PLAY_AGAIN = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String SEPARATOR_LINE = "\n";

    private InputView(){ }

    public static String askNum(Scanner SCANNER){
        OutputView.printMsg(ASK_NUMBER_MSG);
        OutputView.printMsg(SEPARATOR_LINE);
        return SCANNER.nextLine();
    }

    public static String askPlayAgain(Scanner SCANNER){
        OutputView.printMsg(ASK_PLAY_AGAIN);
        OutputView.printMsg(SEPARATOR_LINE);
        return SCANNER.nextLine();
    }
}
