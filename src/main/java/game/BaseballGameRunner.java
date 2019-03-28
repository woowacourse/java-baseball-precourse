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
     * @param baseballGameInterface 입출력 방법을 선택
     * @return 체이닝을 위하여 자기 자신을 반환.
     */
    public BaseballGameRunner with(BaseballGameInterface baseballGameInterface) {
        this.baseballGameInterface = baseballGameInterface;
        return this;
    }

    /**
     * 전체 게임을 시작한다. 여러 번의 세트로 진행된다.
     */
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

    /**
     * 게임 한 세트를 진행한다. 한 세트는 사용자가 숫자를 제시하고 비교하여 정딥을 가려내거나 힌트를 주는
     * 일련의 한 과정이다.
     */
    private void runSingleBaseballGame() {
        Baseball baseball = new Baseball();
        baseball.start();

        while (true) {
            OneSetResult result;
            try {
                int[] inputArr = baseballGameInterface.getInputArray();
                result = baseball.playOneSetGame(inputArr);
                baseballGameInterface.presentResult(result);
            } catch (IllegalArgumentException e) {
                continue;
            }

            if (result.isHit()) {
                break;
            }
        }
    }
}
