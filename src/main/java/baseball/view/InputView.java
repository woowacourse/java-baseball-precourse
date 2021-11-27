package baseball.view;

import baseball.InputValidation;
import baseball.domain.vo.number.Number;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String NEW_GAME = "1";

    private final InputValidation validator;

    public InputView(InputValidation validator) {
        this.validator = validator;
    }

    public Number guessNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        final String input = readLine();
        validator.validateGuessNumber(input);
        return new Number(input);
    }

    public boolean wantNewGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        final String input = readLine();
        validator.validateNewGameInput(input);
        return isNewGame(input);
    }

    public boolean isNewGame(String input) {
        return input.equals(NEW_GAME);
    }


    private String readLine() {
        return Console.readLine();
    }
}
