package baseball.domain;

import baseball.utils.RandomNumberList;

import java.util.List;
import java.util.Objects;

import static baseball.Constants.ANSWER_LIST_LENGTH;

public class Game {

    private List<Integer> answerNumbers;
    private boolean isOver;

    public Game() {
    }

    private void reset() {
        this.answerNumbers = RandomNumberList.generate();
        this.isOver = false;
    }

    public void start() {
        reset();

        while (!this.isOver) {
            isOver = this.play();
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
            if (curIdx >= ANSWER_LIST_LENGTH) break;

            int curInput = this.answerNumbers.get(curIdx);

            if (Objects.equals(input.get(curIdx), curInput)) {
                strikeCount++;
                continue;
            }

            int ballIdx;
            for (ballIdx = 0; ballIdx < ANSWER_LIST_LENGTH; ballIdx++) {
                if (Objects.equals(input.get(ballIdx), curInput)) {
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
            hint = ballCount + "볼 ";
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
