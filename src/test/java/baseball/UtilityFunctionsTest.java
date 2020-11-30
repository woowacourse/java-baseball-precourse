package baseball;

import static baseball.Constants.GAME_MAX_BASEBALL_PITCH;
import static baseball.Constants.GAME_MIN_BASEBALL_NUMBER;
import static baseball.Constants.MESSAGE_RESULT_BALL;
import static baseball.Constants.MESSAGE_RESULT_NOTHING;
import static baseball.Constants.MESSAGE_RESULT_STRIKE;
import static baseball.Constants.STRING_USER_EXIT;
import static baseball.Constants.STRING_USER_NOT_EXIT;
import static baseball.UtilityFunctions.generateResultString;
import static baseball.UtilityFunctions.parseGameExitString;
import static baseball.UtilityFunctions.parseGuessString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class UtilityFunctionsTest {

    @Test
    void generateResultString_AllStrikes_Pass() {
        final int[] answerArray = new int[GAME_MAX_BASEBALL_PITCH];
        int number = GAME_MIN_BASEBALL_NUMBER;
        for (int index = 0; index < GAME_MAX_BASEBALL_PITCH; index++) {
            answerArray[index] = number++;
        }

        BaseballNumbers answer = new BaseballNumbers(answerArray);

        BaseballResult result = new BaseballResult(answer, answer);
        assertEquals(
            GAME_MAX_BASEBALL_PITCH + MESSAGE_RESULT_STRIKE,
            generateResultString(result)
        );
    }

    @Test
    void generateResultString_AllBalls_Pass() {
        final int[] answerArray = new int[GAME_MAX_BASEBALL_PITCH];
        final int[] userGuessArray = new int[GAME_MAX_BASEBALL_PITCH];

        int number = GAME_MIN_BASEBALL_NUMBER;
        for (int index = 0; index < GAME_MAX_BASEBALL_PITCH; index++) {
            answerArray[index] = number++;
            userGuessArray[(index + 1) % GAME_MAX_BASEBALL_PITCH] = number;
        }

        BaseballNumbers answer = new BaseballNumbers(answerArray);
        BaseballNumbers userGuess = new BaseballNumbers(userGuessArray);

        BaseballResult result = new BaseballResult(answer, userGuess);
        assertEquals(
            GAME_MAX_BASEBALL_PITCH + MESSAGE_RESULT_BALL,
            generateResultString(result)
        );
    }

    @Test
    void generateResultString_AllBallsExceptOneStrike_Pass() {
        final int[] answerArray = new int[GAME_MAX_BASEBALL_PITCH];
        final int[] userGuessArray = new int[GAME_MAX_BASEBALL_PITCH];

        int number = GAME_MIN_BASEBALL_NUMBER;
        for (int index = 0; index < GAME_MAX_BASEBALL_PITCH - 1; index++) {
            answerArray[index] = number;
            userGuessArray[(index + 1) % (GAME_MAX_BASEBALL_PITCH - 1)] = number;
            number++;
        }
        answerArray[GAME_MAX_BASEBALL_PITCH - 1] = number;
        userGuessArray[GAME_MAX_BASEBALL_PITCH - 1] = number;

        BaseballNumbers answer = new BaseballNumbers(answerArray);
        BaseballNumbers userGuess = new BaseballNumbers(userGuessArray);

        BaseballResult result = new BaseballResult(answer, userGuess);
        assertEquals(
            (GAME_MAX_BASEBALL_PITCH - 1) + MESSAGE_RESULT_BALL + ' ' + 1 + MESSAGE_RESULT_STRIKE,
            generateResultString(result)
        );
    }

    @Test
    void generateResultString_NoBallAndNoStrike_Pass() {
        final int[] answerArray = new int[GAME_MAX_BASEBALL_PITCH];
        final int[] userGuessArray = new int[GAME_MAX_BASEBALL_PITCH];

        int number = GAME_MIN_BASEBALL_NUMBER;
        for (int index = 0; index < GAME_MAX_BASEBALL_PITCH; index++) {
            answerArray[index] = number++;
        }
        for (int index = 0; index < GAME_MAX_BASEBALL_PITCH; index++) {
            userGuessArray[index] = number++;
        }

        BaseballNumbers answer = new BaseballNumbers(answerArray);
        BaseballNumbers userGuess = new BaseballNumbers(userGuessArray);

        BaseballResult result = new BaseballResult(answer, userGuess);
        assertEquals(
            MESSAGE_RESULT_NOTHING,
            generateResultString(result)
        );
    }

    @Test
    void parseGuessString_SameOrder_Pass() {
        int[] answerArray = new int[]{1, 4, 5};
        String userGuessString = "145";
        assertEquals(answerArray, parseGuessString(userGuessString));
    }

    @Test
    void parseGameExitString_UserExitString_True() {
        assertTrue(parseGameExitString(STRING_USER_EXIT));
    }

    @Test
    void parseGameExitString_UserNotExitString_False() {
        assertFalse(parseGameExitString(STRING_USER_NOT_EXIT));
    }

    @Test
    void parseGameExitString_InvalidString_ExceptionThrown() {
        try {
            parseGameExitString("This is an invalid string");
            fail("This test should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorMessages.INPUT_INVALID_STRING.getMessage(), e.getMessage());
        }
    }
}
