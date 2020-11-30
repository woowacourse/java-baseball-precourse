package view;

import baseball.Numbers;
import utils.InputValidator;
import utils.NumbersFactory;

import java.util.Scanner;

public class InputView {
    private static final String ASK_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ASK_PLAY_AGAIN_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String SEPARATOR_LINE = "\n";

    private InputView(){ }

    public static Numbers getNumbers(Scanner scanner, int digits){
        OutputView.printMsg(ASK_NUMBER_MESSAGE);
        OutputView.printMsg(SEPARATOR_LINE);

        try{
            String answer = scanner.nextLine();
            InputValidator.isValidNumbers(answer, digits);
            return NumbersFactory.createNumbers(answer);
        }catch (IllegalArgumentException IAE){
            IAE.printStackTrace();
            return getNumbers(scanner, digits);
        }
    }

    public static String getPlayAgainButton(Scanner scanner){
        OutputView.printMsg(ASK_PLAY_AGAIN_MESSAGE);
        OutputView.printMsg(SEPARATOR_LINE);

        try{
            String answer = scanner.nextLine();
            InputValidator.isValidPlayAgainAnswer(answer);
            return answer;
        }catch (IllegalArgumentException IAE){
            IAE.printStackTrace();
            return getPlayAgainButton(scanner);
        }
    }
}
