package baseball;

import java.util.HashMap;
import java.util.Map;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class User {

    private static final int RANDOM_START_INCLUSIVE = 1;
    private static final int RANDOM_END_INCLUSIVE = 9;
    private static final String SPACE = " ";
    private static final String REGEX = "^[1-9]{3}$";
    private static final int FOUL = 0;

    protected Map<String, Integer> countStrikeBall(final String answer, final String guessNumber) {
        final Map<String, Integer> strikeBallCount = new HashMap<>();

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < answer.length(); i++) {
            int strikeBall = determineStrikeBall(answer, i, guessNumber);

            if (strikeBall == 1) {
                strike = addStrikeBall(strike, ball, strikeBall);
            }

            if (strikeBall == 2) {
                ball = addStrikeBall(strike, ball, strikeBall);
            }
        }

        strikeBallCount.put(String.valueOf(DeterminationPitching.STRIKE), strike);
        strikeBallCount.put(String.valueOf(DeterminationPitching.BALL), ball);

        return strikeBallCount;
    }

    private int addStrikeBall(int strike, int ball, final int strikeBall) {
        if (strikeBall == 1) {
            strike++;
            return strike;
        }

        if (strikeBall == 2) {
            ball++;
            return ball;
        }

        return FOUL;
    }

    private int determineStrikeBall(final String answer, final int i, final String guessNumber) {
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

    protected void printHintMessage(final String hintMessage) {
        System.out.println(hintMessage);
    }

    protected String writeHintMessage(final int strike, final int ball) {

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

    private String appendNothingHintMessage() {
        return String.valueOf(DeterminationPitching.NOTHING.determinePitching());
    }

    private String appendStrikeHintMessage(final int strike) {
        return strike + String.valueOf(DeterminationPitching.STRIKE.determinePitching());
    }

    private String appendBallHintMessage(final int ball) {
        return ball + String.valueOf(DeterminationPitching.BALL.determinePitching());
    }

    protected boolean checkCorrect(final String answer, final String guessAnswer) {
        return answer.equals(guessAnswer);
    }

    protected void printInputMessage() {
        System.out.print(Messages.INPUT_NUMBER_MESSAGE.printMessages());
    }

    protected String inputGuessNumber() {
        return Console.readLine();
    }

    protected void validateGuessNumber(final String inputGuessNumber) {
        if (!inputGuessNumber.matches(REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    protected String makeAnswerNumber() {
        final StringBuilder stringBuilder = new StringBuilder();

        while (checkLength(stringBuilder)) {
            int number = inputAnswerNumber();

            if (validateAnswerNumber(stringBuilder, number)) {
                connectAnswerNumbers(stringBuilder, number);
            }
        }

        return stringBuilder.toString();
    }

    private void connectAnswerNumbers(final StringBuilder stringBuilder, final int number) {
        stringBuilder.append(number);
    }

    private boolean validateAnswerNumber(final StringBuilder stringBuilder, final int number) {
        return !checkDuplicate(stringBuilder, number);
    }

    private boolean checkDuplicate(final StringBuilder stringBuilder, final int number) {
        return stringBuilder.toString().contains(String.valueOf(number));
    }

    private boolean checkLength(final StringBuilder stringBuilder) {
        return stringBuilder.length() < 3;
    }

    private int inputAnswerNumber() {
        return Randoms.pickNumberInRange(RANDOM_START_INCLUSIVE, RANDOM_END_INCLUSIVE);
    }

}
