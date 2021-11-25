package baseball;

import java.util.List;
import java.util.Map;

public class Game {
    Computer computer = new Computer();
    Player player = new Player();
    Referee referee = new Referee();

    public void play() {
        referee.resetCount();
        OutputView.numberInputMessageShow();
        List<Ball> userBalls = player.selectBalls(InputView.StringChangeList());
        for (int i = 0; i < Constant.MAX_SIZE; i++) {
            referee.ballsCompare(computer.getBalls(), userBalls.get(i));
        }
        Map<BallResult, Integer> totalResult = referee.getResult();
        OutputView.gameResultShow(totalResult.get(BallResult.STRIKE), totalResult.get(BallResult.BALL));
    }
}
