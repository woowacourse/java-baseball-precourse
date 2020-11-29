package baseball;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class GameManagerTest {
    @RepeatedTest(10)
    void testGenerateAnswer() {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        GameManager gameManager = new GameManager();
        ArrayList<Integer> answer = gameManager.getAnswer();
        for (Integer i : answer) {
            assertNotEquals(0, i);
            hashSet.add(i);
        }
        assertEquals(GameManager.NUMBER_ANSWER, hashSet.size());
    }

    @Test
    void testCheckAnswer() {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        answer.add(4);
        answer.add(8);
        answer.add(2); // {4, 8, 2}
        GameManager gameManager = new GameManager(4, 8, 2);
        assertTrue(gameManager.checkAnswer(answer));
        answer.set(0, 1); // {1, 8, 2}
        assertFalse(gameManager.checkAnswer(answer));
    }

    @Test
    void testRequestReplay() {
        GameManager gameManager = new GameManager();
        String[] correctInputArray = {"1", "2"};
        String[] faultInputArray = {"3", "0", "abc"};
        for (String input : correctInputArray) {
            Scanner scanner = new Scanner(input);
            assertEquals(Integer.parseInt(input), gameManager.requestReplay(scanner));
        }
        for (String input : faultInputArray) {
            Scanner scanner = new Scanner(input);
            try {
                gameManager.requestReplay(scanner);
                fail("IllegalArgumentException가 발생해야됩니다.");
            } catch (IllegalArgumentException iae) {
            }
        }
    }

    @Test
    void testRequestAnswer() {
        GameManager gameManager = new GameManager();
        String[] correctInputArray = {"152", "482"};
        String[] faultInputArray = {"32", "1234", "045", "405", "454", "abc"};
        ArrayList<ArrayList<Integer>> correctResult = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < correctInputArray.length; i++) {
            correctResult.add(stringToList(correctInputArray[i]));
        }
        for (int i = 0; i < correctInputArray.length; i++) {
            Scanner scanner = new Scanner(correctInputArray[i]);
            assertEquals(correctResult.get(i), gameManager.requestAnswer(scanner));
        }
        for (String input : faultInputArray) {
            Scanner scanner = new Scanner(input);
            try {
                gameManager.requestAnswer(scanner);
                fail("IllegalArgumentException가 발생해야됩니다.");
            } catch (IllegalArgumentException iae) {
            }
        }
    }

    private ArrayList<Integer> stringToList(String string) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < string.length(); i++) {
            result.add(string.charAt(i) - '0');
        }
        return result;
    }
}
