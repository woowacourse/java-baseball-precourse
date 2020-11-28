package view;

import java.util.Scanner;

public class InputView {
    private static final String ASK_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ASK_PLAY_AGAIN_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String SEPARATOR_LINE = "\n";

    private InputView(){ }

    public static String askGuess(Scanner scanner){
        OutputView.printMsg(ASK_NUMBER_MESSAGE);
        OutputView.printMsg(SEPARATOR_LINE);
        return scanner.nextLine();
    }

    public static String askPlayAgain(Scanner scanner){
        OutputView.printMsg(ASK_PLAY_AGAIN_MESSAGE);
        OutputView.printMsg(SEPARATOR_LINE);
        return scanner.nextLine();
    }
}
