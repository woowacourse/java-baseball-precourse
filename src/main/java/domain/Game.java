package domain;

import utils.GameUtils;

import java.util.List;
import java.util.Objects;

public class Game {

    private List<Integer> answerNumbers;

    public Game() {
    }

    private void reset() {
        this.answerNumbers = GameUtils.generateAnswerNumberList();
    }

    public void start() {
        reset();

        //TODO: should be removed
        System.out.println("answer : " + this.answerNumbers);

        boolean isGameOver = false;

        while (!isGameOver) {
            isGameOver = this.play();
        }

        boolean shouldRestart = Player.getGameRestartInput();
        if (shouldRestart) {
            start();
        }
    }

    private boolean play() {
        List<Integer> input = Player.getAnswerInput();

        String hint = checkAnswerInput(input);

        return this.checkGameOver(hint);
    }

    private String checkAnswerInput(List<Integer> input) {
        int strikeCount = 0;
        int ballCount = 0;
        int curIdx;
        for (curIdx = 0; ; curIdx++) {
            if (curIdx >= 3) break;

            int curInput = this.answerNumbers.get(curIdx);

            if (Objects.equals(input.get(curIdx), curInput)) {
                strikeCount++;
                continue;
            }

            int idx;
            for (idx = curIdx; idx < 3; idx++) {
                if (Objects.equals(input.get(idx), curInput)) {
                    ballCount++;
                    break;
                }
            }
        }

        return this.giveHint(strikeCount, ballCount);
    }

    private String giveHint(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }

        String hint = "";

        if (ballCount > 0) {
            hint += ballCount + "볼 ";
        }
        if (strikeCount > 0) {
            hint += strikeCount + "스트라이크";
        }

        return hint;
    }

    private boolean checkGameOver(String hint) {
        System.out.println(hint);

        if (Objects.equals(hint, "3스트라이크")) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }
}
