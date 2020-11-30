package controller;

import static domain.Message.INPUT_NUMBER;

import baseball.BaseballGame;
import domain.BaseballNumber;
import domain.Hint;
import domain.Player;
import java.util.List;
import java.util.Scanner;
import utils.RandomNumbers;

/**
 * @author yhh1056
 * @since 2020/11/26
 */
public class BaseballGameController {
    private static final int RANDOM_NUMBERS_SIZE = 3;

    private final Scanner scanner;
    private Player player;
    private BaseballGame baseballGame;

    public BaseballGameController(final Scanner scanner) {
        this.scanner = scanner;
        this.player = new Player();
        this.baseballGame = new BaseballGame(new BaseballNumber(nonDuplicateNumber()));
    }

    private List<Integer> nonDuplicateNumber() {
        return RandomNumbers.getInstance(RANDOM_NUMBERS_SIZE);
    }

    public void play() {
        while (true) {
            BaseballNumber playerBaseballNumber = createBaseball();
            if (isBingo(playerBaseballNumber)) {
                choiceRestartOrFinish();
                return;
            }
            showHint(playerBaseballNumber);
        }
    }

    private BaseballNumber createBaseball() {
        showInputMessage();
        return player.createBaseballNumber(getInput());
    }

    private void showInputMessage() {
        System.out.print(INPUT_NUMBER.toString());
    }

    private String getInput() {
        return scanner.nextLine();
    }

    private boolean isBingo(BaseballNumber playerBaseballNumber) {
        return baseballGame.matchBaseball(playerBaseballNumber);
    }

    private void choiceRestartOrFinish() {
        if (isRestart()) {
            this.baseballGame = new BaseballGame(new BaseballNumber(nonDuplicateNumber()));
        }
    }

    private boolean isRestart() {
        return player.choiceRestartGameOrFinish(getInput());
    }

    private void showHint(BaseballNumber playerBaseballNumber) {
        Hint hint = baseballGame.countStrikeAndBall(playerBaseballNumber);
        System.out.println(hint);
    }
}
