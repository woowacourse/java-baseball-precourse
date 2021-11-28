package baseball.domain;

import static baseball.constants.NumberConstant.ANSWER_LIST_LENGTH;
import static baseball.constants.OutputMessage.BALL;
import static baseball.constants.OutputMessage.CONGRATULATION_MESSAGE;
import static baseball.constants.OutputMessage.FINISH_GAME_CONDITION;
import static baseball.constants.OutputMessage.NO_MATCH;
import static baseball.constants.OutputMessage.STRIKE;

import java.util.List;
import java.util.Objects;

public class Judge {

    public static String checkAnswerInput(List<Integer> playerInput, List<Integer> answerList) {
        int strikeCount = countStrikes(playerInput, answerList);
        int ballCount = countBalls(playerInput, answerList);
        return giveHint(strikeCount, ballCount);
    }

    public static boolean checkGameOver(String hint) {
        boolean isGameOver = false;

        if (Objects.equals(hint, FINISH_GAME_CONDITION)) {
            System.out.println(CONGRATULATION_MESSAGE);
            isGameOver = true;
        }

        return isGameOver;
    }

    private static int countStrikes(List<Integer> playerInput, List<Integer> answerList) {
        int strikeCount = 0;
        for (int idx = 0; idx < ANSWER_LIST_LENGTH; idx++) {
            if (Objects.equals(playerInput.get(idx), answerList.get(idx))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private static int countBalls(List<Integer> playerInput, List<Integer> answerList) {
        int ballCount = 0;
        for (int playerInputIdx = 0; playerInputIdx < ANSWER_LIST_LENGTH; playerInputIdx++) {
            if (checkIfBall(playerInput.get(playerInputIdx), answerList)) {
               ballCount++;
            }
        }
        return ballCount;
    }

    private static boolean checkIfBall(int curPlayerInput, List<Integer> answerList) {
        for (int answerNum : answerList) {
            if (Objects.equals(curPlayerInput, answerNum)) {
                return true;
            }
        }
        return false;
    }

    private static String giveHint(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            return NO_MATCH;
        }

        String hint = "";

        if (ballCount > 0) {
            hint += ballCount + BALL;
        }

        if (strikeCount > 0) {
            hint += strikeCount + STRIKE;
        }

        return hint;
    }
}
