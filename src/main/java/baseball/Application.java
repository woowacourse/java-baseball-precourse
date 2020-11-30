package baseball;

import baseball.controller.BaseballGame;
import baseball.model.Numbers;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        setupInputSystem(scanner);      /* InputView에서 사용할 Scanner 객체를 세팅합니다. */

        do {
            BaseballGame baseballGame = BaseballGame.createNewGame(Numbers.createRandomNumbers());  /* 중복되지 않는 3자리 수와 함께 게임 생성 */
            baseballGame.play();
        } while (askRestart());

        OutputView.showTerminationMessage();
    }

    /* InputView에 사용될 Scanner 객체를 설정하는 메소드 */
    public static void setupInputSystem(Scanner scanner) {
        InputView.setScanner(scanner);
    }

    /* 재시작 여부를 묻는 로직, 예외 입력에 대해 재입력을 요구 */
    public static boolean askRestart() {
        try {
            String userInput = InputView.getRestartChoice();    /* 재시작 여부를 묻고 값을 받아옵니다. */
            return valueOfChoice(userInput);                    /* 입력값을 검증하고 재시작 여부를 판단합니다. */
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e.getMessage());
            return askRestart();
        }
    }

    /* 입력값으로 재시작 여부를 판별해 boolean으로 리턴합니다.*/
    public static boolean valueOfChoice(String choice) {
        final int RESTART = 1;
        final int TERMINATE = 2;
        int choiceValue = Integer.parseInt(choice);

        if (choiceValue == RESTART) {
            return true;
        }
        if (choiceValue == TERMINATE) {
            return false;
        }
        throw new IllegalArgumentException("1 혹은 2만 입력가능합니다.");
    }
}
