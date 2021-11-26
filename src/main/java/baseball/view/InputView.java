package baseball.view;

import java.util.Objects;

import baseball.domain.Number;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String NEW_GAME = "1";
    private static final String EXIT = "2";

    private static final int CORRECT_NUMBER_LENGTH = 3;

    private static final String NUMERIC_FILTER = "[1-9]+";

    public Number guessNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        final String input = readLine();
        validateAttackInput(input);
        return new Number(input);
    }

    private String readLine() {
        return Console.readLine();
    }

    private void validateAttackInput(String input) {
        if (isContainsZero(input)) {
            throw new IllegalArgumentException("1 ~ 9 까지의 숫자만 입력할 수 있습니다 ! 게임 종료");
        }

        if (!isCorrectLength(input)) {
            throw new IllegalArgumentException("세 개의 숫자만 입력할 수 있습니다 ! 게임 종료");
        }

        if (!isNumeric(input)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다 ! 게임 종료");
        }
    }

    private boolean isContainsZero(String input) {
        return input.contains("0");
    }

    private boolean isCorrectLength(String input) {
        return Objects.equals(input.length(), CORRECT_NUMBER_LENGTH);
    }

    private boolean isNumeric(String input) {
        return input.matches(NUMERIC_FILTER);
    }

    public boolean wantNewGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return isNewGame(readLine());
    }

    public boolean isNewGame(String input) {
        validateNewGameInput(input);
        return input.equals(NEW_GAME);
    }

    private void validateNewGameInput(String input) {
        if (!input.equals(NEW_GAME) && !input.equals(EXIT)) {
            throw new IllegalArgumentException("1 혹은 2만 입력할 수 있습니다 ! 게임 종료");
        }
    }
}
