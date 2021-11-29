package baseball.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import baseball.domain.DeterminationPitching;
import camp.nextstep.edu.missionutils.Console;

public class User {

    private static final String REGEX = "^[1-9]{3}$";
    private static final int FOUL = 0;

    public String inputRestartOrNotNumber() {
        return Console.readLine();
    }

    public String inputGuessNumber() {
        return Console.readLine();
    }

    public Map<String, Integer> countStrikeBall(final String answer, final String guessNumber) {
        final Map<String, Integer> strikeBallCount = new HashMap<>();

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < answer.length(); i++) {
            int strikeBall = determineStrikeBall(answer, i, guessNumber);

            if (strikeBall == 1) {
                strike = addStrikeBall(strike, ball, strikeBall);
            } else if (strikeBall == 2) {
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
        } else if (strikeBall == 2) {
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

    public void validateGuessNumber(final String inputGuessNumber) {
        if (!inputGuessNumber.matches(REGEX) || checkDuplicateGuessNumber(inputGuessNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkDuplicateGuessNumber(final String inputGuessNumber) {
        boolean checkDuplicate = false;

        final Set<Character> guessNumbers = new HashSet<>();
        char[] guessNumberCharacters = inputGuessNumber.toCharArray();

        for (final char guessNumberCharacter : guessNumberCharacters) {
            guessNumbers.add(guessNumberCharacter);
        }

        if (guessNumbers.size() < 3) {
            checkDuplicate = true;
        }

        return checkDuplicate;
    }
}
