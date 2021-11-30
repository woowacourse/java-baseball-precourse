package baseball;

import static baseball.StringUtil.END;

import baseball.inputmanager.InputManger;
import baseball.inputmanager.StartEndButton;
import baseball.inputmanager.UserGuessedNumberManager;

public class BaseBallGame {
    private static final String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NUMBER_REQUEST_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String START_END_BUTTON = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final InputManger<Integer[]> userGuessedNumberManager = new UserGuessedNumberManager();
    private static final InputManger<Integer> startEndButton = new StartEndButton();

    private GameResult result;
    private boolean end = false;

    public void start() {
        while (!end) {
            play();
            end = checkUserWantToEnd();
        }
    }

    private void play() {
        GivenNumbers givenNumbers = new GivenNumbers();
        do {
            printNumberRequestMessage();
            result = givenNumbers.calculateGameResult((Integer[]) userGuessedNumberManager.getInput());
            System.out.println(result.toPrint());
        } while (!checkThreeStrike());
    }

    private boolean checkUserWantToEnd() {
        System.out.println(GAME_END);
        System.out.println(START_END_BUTTON);
        return startEndButton.getInput() == END;
    }

    private boolean checkThreeStrike() {
        return result.isThreeStrike();
    }

    private void printNumberRequestMessage() {
        System.out.print(NUMBER_REQUEST_MESSAGE);
    }
}
