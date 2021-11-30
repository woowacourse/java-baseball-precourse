package baseball.game;

import baseball.io.Output;
import camp.nextstep.edu.missionutils.Console;
import static baseball.game.Command.RESTART;

public class BaseballGame implements Runnable {
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String SELECT_MODE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final BaseballGenerator baseBallGenerator;

    public BaseballGame(BaseballGenerator baseBallGenerator) {
        this.baseBallGenerator = baseBallGenerator;
    }

    @Override
    public void run() {
        BaseballMatcher baseballMatcher = new BaseballMatcher(this.baseBallGenerator.generateBaseBall());

        while (true) {
            Output.print(INPUT_NUMBER);
            BaseballCount result = baseballMatcher.match(new Baseball(Console.readLine()));
            Output.println(result.toString());

            if (result.isWin()) {
                Output.println(END_GAME);
                break;
            }
        }

        finishOrRestartGame();
    }

    private void finishOrRestartGame() {
        Output.println(SELECT_MODE);
        Command command = Command.create(Console.readLine());
        isRestart(command);
    }

    private void isRestart(Command command) {
        if (command == RESTART) {
            new BaseballGame(new ComputerBaseballGenerator()).run();
        }
    }
}
