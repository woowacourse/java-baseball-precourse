package baseball.domain;

import java.util.List;
import java.util.Objects;

import static baseball.constants.NumberConstant.ANSWER_LIST_LENGTH;
import static baseball.constants.OutputMessage.BALL;
import static baseball.constants.OutputMessage.CONGRATULATION_MESSAGE;
import static baseball.constants.OutputMessage.FINISH_GAME_CONDITION;
import static baseball.constants.OutputMessage.NO_MATCH;
import static baseball.constants.OutputMessage.STRIKE;

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
        if (strikeCount == 0 && ballCount == 0) return NO_MATCH;

        String hint = "";

        if (ballCount > 0) {
            hint += ballCount + BALL;
        }
        if (strikeCount > 0) {
            hint += strikeCount + STRIKE;
        }

        return hint;
    }

    public boolean checkGameOver(String hint) {
        System.out.println(hint);

        if (Objects.equals(hint, FINISH_GAME_CONDITION)) {
            System.out.println(CONGRATULATION_MESSAGE);
            return true;
        }

        return false;
    }
}
