package baseball;

import baseball.ball.Ball;
import baseball.ball.BallResult;
import baseball.players.Computer;
import baseball.players.Player;
import baseball.players.Referee;
import baseball.utils.InputView;
import baseball.utils.OutputView;

import java.util.List;
import java.util.Map;

public class Game {
    Computer computer = new Computer();
    Player player = new Player();
    Referee referee = new Referee();

    public void play() {
        computer.selectBalls();
        while (true){
            OutputView.numberInputMessageShow();
            List<Ball> userBalls = player.selectBalls(InputView.StringChangeList());
            calculate(userBalls);
            if (referee.allStrikeCheck()) {
                break;
            }
        }
    }

    public void calculate(List<Ball> userBalls) {
        referee.totalUserBallsCompare(computer.getBalls(), userBalls);
        Map<BallResult, Integer> strikeBallCountResult = referee.getStrikeBallCountRecords();
        OutputView.gameResultShow(strikeBallCountResult.get(BallResult.STRIKE), strikeBallCountResult.get(BallResult.BALL));
    }


    public int replay() {
        OutputView.gameEndMessageShow();
        String input = InputView.trimInput();
        return Integer.parseInt(input);
    }
}
