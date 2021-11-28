package baseball;

import baseball.inputmanager.InputManger;
import baseball.inputmanager.StartEndButton;
import baseball.inputmanager.UserGuessedNumberManager;

import java.util.Map;

import static baseball.StringUtil.*;

public class BaseBallGame {
    private static final String STRIKE_TO_PRINT = "스트라이크";
    private static final String BALL_TO_PRINT = "볼";
    private static final String NOTHING = "낫싱";
    private static final String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NUMBER_REQUEST_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String START_END_BUTTON = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final InputManger<Integer[]> userGuessedNumberManager = new UserGuessedNumberManager();
    private static final InputManger<Integer> startEndButton = new StartEndButton();

    private Map<String, Integer> result;
    private boolean end = false;

    public void start() {
        while (!end) {
            play();
            end = checkUserWantToEnd();
        }
    }

    private void play() {
        GivenNumbers givenNumbers = new GivenNumbers(RandomNumberFactory.generate());
        do {
            printNumberRequestMessage();
            result = givenNumbers.operate((Integer[]) userGuessedNumberManager.getInput());
            printGameResult();
        } while (!allNumbersMatches());
    }

    private boolean checkUserWantToEnd() {
        System.out.println(GAME_END);
        System.out.println(START_END_BUTTON);
        if(startEndButton.getInput() == END){
            return true;
        };
        return false;
    }

    private boolean allNumbersMatches() {
        return result.get(STRIKE) == NUMBER_OF_DIGITS_OF_NUMBER;
    }

    private void printGameResult() {
        StringBuilder resultStringBuilder = resultToStringBuilder();
        if (resultStringBuilder.length() == 0) {
            System.out.println(NOTHING);
            return;
        }
        System.out.println(resultStringBuilder.toString());
    }

    private StringBuilder resultToStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        int strike = result.get(STRIKE);
        int ball = result.get(BALL);
        if (ball > 0) {
            stringBuilder.append(ball);
            stringBuilder.append(BALL_TO_PRINT);
        }
        if (strike > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(strike);
            stringBuilder.append(STRIKE_TO_PRINT);
        }
        return stringBuilder;
    }

    private void printNumberRequestMessage() {
        System.out.print(NUMBER_REQUEST_MESSAGE);
    }
}
