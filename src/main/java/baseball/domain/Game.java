package baseball.domain;

import baseball.utils.RandomNumberList;

import java.util.List;
import java.util.Objects;

import static baseball.Constants.ANSWER_LIST_LENGTH;

public class Game {

    private List<Integer> answerList;
    private boolean isOver;

    public Game() {
    }

    private void reset() {
        this.answerList = RandomNumberList.generate();
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
        int curInputIdx;
        for (curInputIdx = 0; ; curInputIdx++) {
            if (curInputIdx >= ANSWER_LIST_LENGTH) break;

            int curInput = input.get(curInputIdx);

            if (Objects.equals(curInput, this.answerList.get(curInputIdx))) {
                strikeCount++;
                continue;
            }

            if (this.checkIfBall(curInput)) {
                ballCount++;
            }
        }

        return this.giveHint(strikeCount, ballCount);
    }

    private boolean checkIfBall(int curInput) {
        for (int answerNum : this.answerList) {
            if (Objects.equals(curInput, answerNum)) return true;
        }
        return false;
    }

    private String giveHint(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) return "낫싱";

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
