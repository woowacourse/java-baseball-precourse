package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private final Computer computer;
    private final InputValidator inputValidator;

    public Game(Computer computer, InputValidator inputValidator) {
        this.computer = computer;
        this.inputValidator = inputValidator;
    }

    public void playGame() {
        String target = computer.generateTargetNumber();
        do {
            System.out.print(GameConstant.INPUT_MESSAGE);
            String input = Console.readLine();

            inputValidator.validateGameNumberInput(input);

            Baseball baseball = new Baseball(target, input);
            printGameResult(baseball);

            if (isGameOver(baseball)) {
                System.out.println(GameConstant.GAME_OVER_MESSAGE);
                break;
            }
        } while (true);
    }

    private boolean isGameOver(Baseball baseball) {
        return baseball.strikeCount == GameConstant.THREE_STRIKE;
    }

    private void printGameResult(Baseball baseball) {
        StringBuilder sb = new StringBuilder();

        if (baseball.ballCount > 0) {
            sb.append(formatToString(GameConstant.BALL_FORMAT, baseball.ballCount));
        }

        if (baseball.strikeCount > 0) {
            sb.append(formatToString(GameConstant.STRIKE_FORMAT, baseball.strikeCount));
        }

        if (baseball.ballCount == 0 && baseball.strikeCount == 0) {
            sb.append(GameConstant.NOTHING_STRING);
        }

        System.out.println(sb.toString());
    }

    private <T> String formatToString(String format, T target) {
        return String.format(format, target);
    }
}
