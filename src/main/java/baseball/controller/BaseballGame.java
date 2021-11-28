package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.Referee;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;

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
        getNumberFromPlayer();
        printHint();
    }

    public void getNumberFromPlayer() {
        player.setPlayerNumber(InputView.getNumber());
    }

    public void printHint() {
        OutputView.printHintMessage(referee.getHint(player.getPlayerNumber(), computer.getAnswerNumber()));
    }

}
