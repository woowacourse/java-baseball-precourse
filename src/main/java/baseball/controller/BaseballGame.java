package baseball.controller;

import baseball.constant.SystemMessage;
import baseball.model.Computer.Computer;
import baseball.model.Player.Player;
import baseball.model.Referee.Referee;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {
    private final Computer computer;
    private final Player player;
    private final Referee referee;

    public BaseballGame() {
        computer = new Computer();
        player = new Player();
        referee = new Referee();
    }

    public void start() {
        do {
            getNumberFromPlayer();
            printHint(getHint());
        } while (!isGameSet());
    }

    public void getNumberFromPlayer() {
        player.setPlayerNumber(InputView.getNumber());
    }

    public void printHint(int[] hint) {
        printBallHint(hint);
        printStrikeHint(hint);
        printNothingHint(hint);
        printEnter();
    }

    public static void printBallHint(int[] hint) {
        if (hint[0] != 0) {
            OutputView.printCount(hint[0]);
            OutputView.printBallMessage();
        }
    }

    public static void printStrikeHint(int[] hint) {
        if (hint[1] != 0) {
            OutputView.printCount(hint[1]);
            OutputView.printStrikeMessage();
        }
    }

    public static void printNothingHint(int[] hint) {
        if (hint[0] == 0 && hint[1] == 0) {
            OutputView.printNothingMessage();
        }
    }

    public int[] getHint() {
        return referee.getHint(player.getPlayerNumber(), computer.getAnswerNumber());
    }

    public static void printEnter() {
        System.out.println();
    }

    public boolean isGameSet() {
        if (referee.isThreeStrike()) {
            OutputView.printGameSetMessage();
            return true;
        }
        return false;
    }

}
