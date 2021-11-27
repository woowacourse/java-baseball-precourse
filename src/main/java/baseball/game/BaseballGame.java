package baseball.game;

import baseball.io.Output;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame implements Runnable {

    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";

    private final BaseBallGenerator baseBallGenerator;

    public BaseballGame(BaseBallGenerator baseBallGenerator) {
        this.baseBallGenerator = baseBallGenerator;
    }

    @Override
    public void run() {
        BaseBall computerBaseball = this.baseBallGenerator.generateBaseBall();

        while (true) {
            Output.print(INPUT_NUMBER);
            BaseBall baseBall = new BaseBall(Console.readLine());
            break;
        }

    }
}
