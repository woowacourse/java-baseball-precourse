package baseball;

import java.util.List;
import java.util.Map;

public class Game {
    Computer computer = new Computer();
    Player player = new Player();
    Referee referee = new Referee();

    public void play() {
        OutputView.numberInputMessageShow();
        List<Ball> userBalls = player.selectBalls(InputView.StringChangeList());
        for (int i = 0; i < Constant.MAX_SIZE; i++) {
            referee.ballsCompare(computer.getBalls(), userBalls.get(0));
        }
        Map<BallResult, Integer> totalResult = referee.getResult();
        OutputView.gameResultShow(totalResult.get(BallResult.BALL), totalResult.get(BallResult.STRIKE));
    }
}
