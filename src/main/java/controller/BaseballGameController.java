package controller;

import baseball.BaseballGame;
import domain.BaseballNumber;
import domain.Player;
import java.util.Scanner;
import utils.NumberUtils;

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
        this.baseballGame = new BaseballGame();
        this.player = new Player();
    }

    public void play() {
        String input = getInputNumber();
        BaseballNumber playerBaseballNumber = player.createBaseballNumber(input);
    }

    private String getInputNumber() {
        String number = scanner.nextLine();
        validateNumber(number);
        return number;
    }

    private boolean validateNumber(String number) {
        return NumberUtils.isNumeric(number);
    }
}
