package baseball;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import utils.Input;
import utils.Output;
import utils.RandomUtils;

public class NumberBaseBallGame {

    private static final int MIN = 1;
    private static final int MAX = 9;
    private static final int NUMBER_LEN = 3;
    private static final String CONTINUE = "1";
    private static List<Integer> answerNumber;
    private static List<Integer> questionNumber;
    private static int strike, ball;

    private static void initStrikeAndBall() {
        strike = 0;
        ball = 0;
    }

    private static void initGameConfig() {
        answerNumber = new LinkedList<>();
        questionNumber = new LinkedList<>();
        initStrikeAndBall();
    }

    private static void setAnswerNumber() {
        Set<Integer> set = new HashSet<>();

        while (answerNumber.size() < NUMBER_LEN) {
            int num = RandomUtils.nextInt(MIN, MAX);
            if (!set.contains(num)) {
                set.add(num);
                answerNumber.add(num);
            }
        }
    }

    private static void setQuestionNumber() {
        int num = Input.getQuestionNumber();

        while (num > 0) {
            questionNumber.add(num % 10);
            num /= 10;
        }
        Collections.reverse(questionNumber);
    }

    private static void checkAnswer() {
        for (int i = 0; i < NUMBER_LEN; i++) {
            if (answerNumber.get(i).equals(questionNumber.get(i))) {
                strike++;
            } else if (answerNumber.contains(questionNumber.get(i))) {
                ball++;
            }
        }
    }

    private static boolean isThreeStrike() {
        return strike == NUMBER_LEN;
    }

    private static boolean tryAnswer() {
        while (true) {
            initStrikeAndBall();
            setQuestionNumber();
            checkAnswer();
            Output.printBallAndStrike(ball, strike);
            if (isThreeStrike()) {
                Output.printAnswerMessage();
                return true;
            }
        }
    }

    public void run() {
        String flag = CONTINUE;

        while (flag.equals(CONTINUE)) {
            initGameConfig();
            setAnswerNumber();
            if (tryAnswer()) {
                flag = Input.getGameContinueFlag();
            }
        }
    }

}

