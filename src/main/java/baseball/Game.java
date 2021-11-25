package baseball;

import java.util.List;
import java.util.Map;

public class Game {
    Computer computer = new Computer();
    Player player = new Player();
    Referee referee = new Referee();

    public void play() {
        // 게임이 잘 돌아가는지 확인하기 위함
        List<Ball> balls = computer.getBalls();
        for (int i = 0; i < balls.size(); i++) {
            System.out.print(balls.get(i).getValue()+" ");
        }
        // ------------------------
        OutputView.numberInputMessageShow();
        List<Ball> userBalls = player.selectBalls(InputView.StringChangeList());
        for (int i = 0; i < Constant.MAX_SIZE; i++) {
            referee.ballsCompare(computer.getBalls(), userBalls.get(i));
        }
        Map<BallResult, Integer> totalResult = referee.getResult();
        OutputView.gameResultShow(totalResult.get(BallResult.STRIKE), totalResult.get(BallResult.BALL));
    }
}
