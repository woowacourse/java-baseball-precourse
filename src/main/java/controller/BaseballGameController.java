package controller;

import static domain.Message.BINGO;
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
        if (baseballGame.exists(playerBaseballNumber)) {
            showBingoMessage();
            choiceRestartGameOrFinish();
            return;
        }
        Hint hint = baseballGame.countStrikeAndBall(playerBaseballNumber);
        System.out.println(hint);
        restart();
    }

    private void inputBaseballNumber() {
        System.out.print(INPUT_NUMBER.toString());
    }

    private String getInput() {
        return scanner.nextLine();
    }

    private void showBingoMessage() {
        System.out.println(BINGO.toString());
    }

    private void choiceRestartGameOrFinish() {
        switch (getInput()) {
            case RESTART :
                this.baseballGame = new BaseballGame(new BaseballNumber(nonDuplicateNumber()));
                break;
            case ENDGAME :
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void restart() {
        play();
    }
}
