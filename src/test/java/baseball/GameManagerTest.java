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
        GameManager gameManager = new GameManager();
        HashSet<Integer> hashSet = new HashSet<Integer>();
        ArrayList<Integer> answer = gameManager.getAnswer();
        for (Integer i : answer) {
            assertNotEquals(0, i);
            hashSet.add(i);
        }
        assertEquals(GameManager.NUMBER_ANSWER, hashSet.size());
    }

    @Test
    void testCheckAnswer() {
        GameManager gameManager = new GameManager(4, 8, 2);
        String[] inputStrings = {"482", "182", "284", "591"};
        int[][] results = {{3, 0}, {2, 0}, {1, 2}, {0, 0}};
        ArrayList<ArrayList<Integer>> inputs = new ArrayList<ArrayList<Integer>>();
        for (String string : inputStrings) {
            inputs.add(stringToList(string));
        }
        for (int i = 0; i < inputs.size(); i++) {
            GameResult gameResult = gameManager.checkAnswer(inputs.get(i));
            assertEquals(results[i][0], gameResult.getStrike());
            assertEquals(results[i][1], gameResult.getBall());
        }
    }

    @Test
    void testRequestReplay() {
        GameManager gameManager = new GameManager();
        String[] correctInputArray = {"1", "2"};
        String[] faultInputArray = {"\n", "3", "0", "a", "abc"};
        for (String input : correctInputArray) {
            Scanner scanner = new Scanner(input);
            gameManager.requestReplay(scanner);
        }
        for (String input : faultInputArray) {
            Scanner scanner = new Scanner(input);
            try {
                gameManager.requestReplay(scanner);
                String message = String.format("%s는 IllegalArgumentException가 발생해야됩니다.", input);
                fail(message);
            } catch (IllegalArgumentException iae) {
            }
        }
    }

    @Test
    void testRequestAnswer() {
        String[] correctInputArray = {"152", "482"};
        String[] faultInputArray = {"\n", "32", "1234", "045", "405", "454", "abc", "0123"};
        ArrayList<ArrayList<Integer>> correctResult = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < correctInputArray.length; i++) {
            correctResult.add(stringToList(correctInputArray[i]));
        }
        for (int i = 0; i < correctInputArray.length; i++) {
            Scanner scanner = new Scanner(correctInputArray[i]);
            assertEquals(correctResult.get(i), GameManager.requestUserAnswer(scanner));
        }
        for (String input : faultInputArray) {
            Scanner scanner = new Scanner(input);
            try {
                GameManager.requestUserAnswer(scanner);
                String message = String.format("%s는 IllegalArgumentException가 발생해야됩니다.", input);
                fail(message);
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
