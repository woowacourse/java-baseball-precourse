package baseball;

import baseball.BaseballSystem.BaseballValidationImpl;
import baseball.BaseballSystem.Validation;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

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
            System.out.print("Business Logic 처리 완료됨 가정");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
