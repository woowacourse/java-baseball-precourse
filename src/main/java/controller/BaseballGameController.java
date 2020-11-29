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
    private static final String RESTART = "1";
    private static final String ENDGAME = "2";

    private final Scanner scanner;
    private Player player;
    private BaseballGame baseballGame;

    public BaseballGameController(final Scanner scanner) {
        this.scanner = scanner;
        this.baseballGame = new BaseballGame(new BaseballNumber(nonDuplicateNumber()));
        this.player = new Player();
    }

    private List<Integer> nonDuplicateNumber() {
        return RandomNumbers.getInstance(RANDOM_NUMBERS_SIZE);
    }

    public void play() {
        inputBaseballNumber();
        BaseballNumber playerBaseballNumber = player.createBaseballNumber(getInput());
        if (baseballGame.matchBaseball(playerBaseballNumber)) {
            choiceRestartGameOrFinish();
            return;
        }
        showHint(playerBaseballNumber);
        restart();
    }

    private void inputBaseballNumber() {
        System.out.print(INPUT_NUMBER.toString());
    }

    private String getInput() {
        return scanner.nextLine();
    }

    private void choiceRestartGameOrFinish() {
        switch (getInput()) {
            case RESTART :
                this.baseballGame = new BaseballGame(new BaseballNumber(nonDuplicateNumber()));
                play();
                break;
            case ENDGAME :
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void showHint(BaseballNumber playerBaseballNumber) {
        Hint hint = baseballGame.countStrikeAndBall(playerBaseballNumber);
        System.out.println(hint);
    }

    private void restart() {
        play();
    }
}
