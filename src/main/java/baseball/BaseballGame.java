package baseball;

import baseball.BaseballSystem.BaseballRule;
import baseball.BaseballSystem.BaseballValidationImpl;
import baseball.BaseballSystem.Validation;
import baseball.domain.Player;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    private static final boolean OK = true;
    private static final boolean NO = false;

    private final Validation validation;

    public BaseballGame() {
        validation = BaseballValidationImpl.getInstance();
    }

    public void play() {
        do {
            start();
        } while (continueGame());
    }

    private void start() {
        try {
            System.out.print("숫자를 입력해주세요 : ");
            String validPlayerInput = validation.isValidInput(Console.readLine());
            Player player=new Player(validPlayerInput);
            System.out.print("Business Logic 처리 완료됨 가정");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private boolean continueGame() {
        try {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String validContinuePlayerInput = validation.isValidContinueInput(Console.readLine());
            return isContinue(validContinuePlayerInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isContinue(String continuePlayerInput) {
        if (BaseballRule.CONTINUE_GAME.getValue().equals(continuePlayerInput)) {
            return OK;
        } else {
            return NO;
        }
    }
}
