package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class User {

    private static final int RANDOM_START_INCLUSIVE = 1;
    private static final int RANDOM_END_INCLUSIVE = 9;
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String STRIKE_KOREAN = "스트라이크";
    private static final String BALL_KOREAN = "볼";
    private static final String NOTHING = "낫싱";
    public static final int ZERO = 0;
    public static final String STRIKE_ENGLISH = "strike";
    public static final String BALL_ENGLISH = "ball";
    public static final String SPACE = " ";

    public Map<String, Integer> countStrikeBallNumber(final String answer, final String guessNumber) {
        final Map<String, Integer> strikeBallCount = new HashMap<>();

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < answer.length(); i++) {
            int strikeBall = decideStrikeBall(answer, i, guessNumber);

            if (strikeBall == 1) {
                strike = addStrikeBallCount(strike, ball, strikeBall);
            }

            if (strikeBall == 2) {
                ball = addStrikeBallCount(strike, ball, strikeBall);
            }
        }

        strikeBallCount.put(STRIKE_ENGLISH, strike);
        strikeBallCount.put(BALL_ENGLISH, ball);

        return strikeBallCount;
    }

    private int addStrikeBallCount(int strike, int ball, final int strikeBall) {
        if (strikeBall == 1) {
            strike++;
            return strike;
        }

        if (strikeBall == 2) {
            ball++;
            return ball;
        }

        return ZERO;
    }

    private int decideStrikeBall(final String answer, final int i, final String guessNumber) {
        int decide = 0;

        char answerCharacter = answer.charAt(i);
        char guessNumberCharacter = guessNumber.charAt(i);

        if (answerCharacter == guessNumberCharacter) {
            decide = 1;
        }

        if ((answerCharacter != guessNumberCharacter) && (answer.contains(String.valueOf(guessNumberCharacter)))) {
            decide = 2;
        }

        return decide;
    }

    public void printHintMessage(final String hintMessage) {
        System.out.println(hintMessage);
    }

    public String writeHintMessage(final int strike, final int ball) {

        if ((strike == 0) && (ball > 0)) {
            return appendBallHintMessage(ball);
        }

        if ((strike > 0) && (ball == 0)) {
            return appendStrikeHintMessage(strike);
        }

        if ((strike == 0) && (ball == 0)) {
            return appendNothingHintMessage();
        }

        return appendBallHintMessage(ball) + SPACE + appendStrikeHintMessage(strike);
    }

    public String appendNothingHintMessage() {
        return NOTHING;
    }

    public String appendStrikeHintMessage(final int strike) {
        return strike + STRIKE_KOREAN;
    }

    public String appendBallHintMessage(final int ball) {
        return ball + BALL_KOREAN;
    }

    public boolean checkAnswer(final String answer, final String guessAnswer) {
        return answer.equals(guessAnswer);
    }

    public void printInputMessage() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public String inputPlayerNumber() {
        return Console.readLine();
    }

    public String connectEachAnswerNumbers() {
        final StringBuilder stringBuilder = new StringBuilder();

        while (checkAnswerNumberLength(stringBuilder)) {
            int number = inputAnswerNumber();

            if (checkDuplicateNumber(stringBuilder, number)) {
                stringBuilder.append(number);
            }
        }

        return stringBuilder.toString();
    }

    private boolean checkDuplicateNumber(final StringBuilder stringBuilder, final int number) {
        return !stringBuilder.toString().contains(String.valueOf(number));
    }

    private boolean checkAnswerNumberLength(final StringBuilder stringBuilder) {
        return stringBuilder.length() < 3;
    }

    private int inputAnswerNumber() {
        return Randoms.pickNumberInRange(RANDOM_START_INCLUSIVE, RANDOM_END_INCLUSIVE);
    }

}
