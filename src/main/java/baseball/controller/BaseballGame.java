package baseball.controller;

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
            printHint();
        } while (!isGameSet());
    }
    
    public void getNumberFromPlayer() {
        player.setPlayerNumber(InputView.getNumber());
    }

    public void printHint() {
        OutputView.printHintMessage(referee.getHint(player.getPlayerNumber(), computer.getAnswerNumber()));
    }

    public boolean isGameSet() {
        if (referee.isThreeStrike()) {
            OutputView.printGameSetMessage();
            return true;
        }
        return false;
    }

}
