package controller;

import static domain.Message.BINGO;
import static domain.Message.INPUT_NUMBER;
import static domain.Rule.BASEBALL_SIZE;

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
    private final Scanner scanner;
    private Player player;
    private BaseballGame baseballGame;

    public BaseballGameController(final Scanner scanner) {
        this.scanner = scanner;
        this.player = new Player();
        this.baseballGame = new BaseballGame(new BaseballNumber(nonDuplicateNumber()));
    }

    private List<Integer> nonDuplicateNumber() {
        return RandomNumbers.getInstance(BASEBALL_SIZE);
    }

    public void play() {
        while (true) {
            BaseballNumber playerBaseballNumber = createPlayerBaseball();
            if (isBingo(playerBaseballNumber)) {
                showBingoMessage();
                choiceRestartOrFinish();
                break;
            }
            showHint(playerBaseballNumber);
        }
    }

    private BaseballNumber createPlayerBaseball() {
        showInputMessage();
        return player.createBaseballNumber(getInput());
    }

    private void showInputMessage() {
        System.out.print(INPUT_NUMBER);
    }

    private String getInput() {
        return scanner.nextLine();
    }

    private boolean isBingo(BaseballNumber playerBaseballNumber) {
        return baseballGame.matchBaseball(playerBaseballNumber);
    }

    private void showBingoMessage() {
        System.out.println(BINGO);
    }

    private void choiceRestartOrFinish() {
        if (isRestart()) {
            baseballGame = new BaseballGame(new BaseballNumber(nonDuplicateNumber()));
            play();
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
