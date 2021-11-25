package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class User {

    private static final int RANDOM_START_INCLUSIVE = 1;
    private static final int RANDOM_END_INCLUSIVE = 9;
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해 주세요 : ";
    public static final int ZERO = 0;
    public static final String STRIKE_ENGLISH = "strike";
    public static final String BALL_ENGLISH = "ball";

    public Map<String, Integer> countStrikeBallNumber(final String answer, final String guessNumber) {
        final Map<String, Integer> strikeBallCount = new HashMap<>();

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < answer.length(); i++) {
            int strikeBall = decideStrikeBall(answer, i, guessNumber);

            strike += addStrikeBallCount(strike, ball, strikeBall);
            ball += addStrikeBallCount(strike, ball, strikeBall);
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

        if (strike == 2) {
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

    public boolean checkAnswer(final String answer, final String guessNumber) {
        return answer.equals(guessNumber);
    }

    public void printInputMessage() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public String inputPlayerNumber() {
        return Console.readLine();
    }

    public String connectEachAnswerNumbers() {
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            stringBuilder.append(inputAnswerNumber());
        }

        return stringBuilder.toString();
    }

    private int inputAnswerNumber() {
        return Randoms.pickNumberInRange(RANDOM_START_INCLUSIVE, RANDOM_END_INCLUSIVE);
    }

}
