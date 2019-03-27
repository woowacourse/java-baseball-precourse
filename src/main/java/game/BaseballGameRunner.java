import game.Baseball;
import game.OneSetResult;
import ui.BaseballGameInterface;
import ui.ConsoleInterface;

import java.util.Objects;

/**
 * @author delf
 */
public class BaseballGameRunner {
    private BaseballGameInterface baseballGameInterface;

    public BaseballGameRunner with(BaseballGameInterface baseballGameInterface) {
        this.baseballGameInterface = baseballGameInterface;
        return this;
    }

    public void run() {
        if(Objects.nonNull(baseballGameInterface)) {
            baseballGameInterface = new ConsoleInterface();
        }
    }

    private void runSigneBaseballGame() {
        int[] inputArr = baseballGameInterface.getInputArray();

        Baseball baseball = new Baseball();
        baseball.start();

        while (true) {
            OneSetResult result = baseball.playOneSetGame(inputArr);
            baseballGameInterface.presentResult(result);
            if (result.isHit()) {
                break;
            }
        }
    }
}
