package baseball.game;

import baseball.io.Output;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame implements Runnable {

    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

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
            Output.print(result.toString());

            if (result.isWin()) {
                Output.print(END_GAME);
                break;
            }
        }

    }
}
