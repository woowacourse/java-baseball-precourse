package baseball.domain;

import java.util.List;
import java.util.Objects;

import static baseball.Constants.ANSWER_LIST_LENGTH;

public class Judge {

    public Judge() {}

    public String checkAnswerInput(List<Integer> input, List<Integer> answerList) {
        int strikeCount = 0;
        int ballCount = 0;
        int curInputIdx;
        for (curInputIdx = 0; ; curInputIdx++) {
            if (curInputIdx >= ANSWER_LIST_LENGTH) break;

            int curInput = input.get(curInputIdx);

            if (Objects.equals(curInput, answerList.get(curInputIdx))) {
                strikeCount++;
                continue;
            }

            if (this.checkIfBall(curInput, answerList)) {
                ballCount++;
            }
        }

        return this.giveHint(strikeCount, ballCount);
    }

    private boolean checkIfBall(int curInput, List<Integer> answerList) {
        for (int answerNum : answerList) {
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

    public boolean checkGameOver(String hint) {
        System.out.println(hint);

        if (Objects.equals(hint, "3스트라이크")) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }
}
