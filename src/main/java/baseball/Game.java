package baseball;

import java.util.List;

public class Game {
    Computer computer = new Computer();
    Player player = new Player();

    public void play() {
        OutputView.numberInputMessageShow();
        player.selectBalls(InputView.StringChangeList());
    }
}
