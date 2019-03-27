package game;

import game.model.Baseball;
import game.model.OneSetResult;
import ui.BaseballGameInterface;
import ui.ConsoleInterface;

import java.util.Objects;

/**
 * @author delf
 */
public class BaseballGameRunner {
    private BaseballGameInterface baseballGameInterface;

    /**
     *
     * @param baseballGameInterface 입출력
     * @return 체이닝을 위하여 자기 자신을 반환.
     */
    public BaseballGameRunner with(BaseballGameInterface baseballGameInterface) {
        this.baseballGameInterface = baseballGameInterface;
        return this;
    }

    public void run() {
        if (!Objects.nonNull(baseballGameInterface)) {
            baseballGameInterface = new ConsoleInterface();
        }

        while (true) {
            runSingleBaseballGame();
            if (!baseballGameInterface.getTrueOrFalse()) {
                break;
            }
        }
    }

    private void runSingleBaseballGame() {


        Baseball baseball = new Baseball();
        baseball.start();

        while (true) {
            int[] inputArr = baseballGameInterface.getInputArray();
            OneSetResult result = baseball.playOneSetGame(inputArr);
            baseballGameInterface.presentResult(result);
            if (result.isHit()) {
                break;
            }
        }
    }
}
