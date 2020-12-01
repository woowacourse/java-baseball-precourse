package view;

import baseball.Numbers;
import baseball.PlayButton;
import utils.NumbersFactory;

import java.util.Scanner;

public class InputView {
    private static final String ASK_NUMBER_MESSAGE = "숫자를 입력해주세요 : \n";
    private static final String ASK_PLAY_AGAIN_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. \n";

    private InputView(){ }

    public static Numbers getNumbers(Scanner scanner) {
        OutputView.printMsg(ASK_NUMBER_MESSAGE);

        try {
            String answer = getInput(scanner);
            return NumbersFactory.createNumbers(answer);
        } catch (IllegalArgumentException IAE) {
            IAE.printStackTrace();
            return getNumbers(scanner);
        }
    }

    public static PlayButton getPlayAgainButton(Scanner scanner) {
        OutputView.printMsg(ASK_PLAY_AGAIN_MESSAGE);

        try {
            String answer = getInput(scanner);
            return new PlayButton(answer);
        } catch (IllegalArgumentException IAE) {
            IAE.printStackTrace();
            return getPlayAgainButton(scanner);
        }
    }

    private static String getInput(Scanner scanner) {
        return scanner.nextLine();
    }
}
