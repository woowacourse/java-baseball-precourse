package baseball.checker;


import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.players.Players;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class AnswerCheckerTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final Scanner scanner = new Scanner(System.in);
    private final Players players = new Players(scanner);
    private final AnswerChecker answerChecker = new AnswerChecker(players);
    private final static int COMPUTER_NUMBER = 123;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        players.initializeComputerNumbersWith(COMPUTER_NUMBER);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    /*
     * 스트라이크 :
     * 1스트라이크
     * 1볼 1스트라이크
     * 2볼 1스트라이크
     * 2스트라이크
     * 3스트라이크
     *
     * 볼 :
     * 1볼
     * 2불
     * 3볼
     *
     * 낫싱
     * */

    @DisplayName("1스트라이크")
    @Test
    void oneStrike() {
        String[] inputs = {"189", "726", "583"};
        for (String input : inputs) {
            players.initializeUserNumbersWith(input);
            answerChecker.calculateResult();
            answerChecker.printResult();
            assertEquals("1스트라이크", outputStreamCaptor.toString().trim());
            outputStreamCaptor.reset();
            answerChecker.clear();
        }
    }

    @DisplayName("1볼 1스트라이크")
    @Test
    void oneBallOneStrike() {
        String[] inputs = {"138", "921", "253"};
        for (String input : inputs) {
            players.initializeUserNumbersWith(input);
            answerChecker.calculateResult();
            answerChecker.printResult();
            assertEquals("1볼 1스트라이크", outputStreamCaptor.toString().trim());
            outputStreamCaptor.reset();
            answerChecker.clear();
        }
    }

    @DisplayName("2볼 1스트라이크")
    @Test
    void twoBallOneStrike() {
        String[] inputs = {"132", "321", "213"};
        for (String input : inputs) {
            players.initializeUserNumbersWith(input);
            answerChecker.calculateResult();
            answerChecker.printResult();
            assertEquals("2볼 1스트라이크", outputStreamCaptor.toString().trim());
            outputStreamCaptor.reset();
            answerChecker.clear();
        }
    }

    @DisplayName("2스트라이크")
    @Test
    void twoStrike() {
        String[] inputs = {"129", "163", "423"};
        for (String input : inputs) {
            players.initializeUserNumbersWith(input);
            answerChecker.calculateResult();
            answerChecker.printResult();
            assertEquals("2스트라이크", outputStreamCaptor.toString().trim());
            outputStreamCaptor.reset();
            answerChecker.clear();
        }
    }

    @DisplayName("3스트라이크")
    @Test
    void threeStrike() {
        String[] inputs = {"123"};
        for (String input : inputs) {
            players.initializeUserNumbersWith(input);
            answerChecker.calculateResult();
            answerChecker.printResult();
            assertEquals("3스트라이크", outputStreamCaptor.toString().trim());
            outputStreamCaptor.reset();
            answerChecker.clear();
        }
    }

    @DisplayName("1볼")
    @Test
    void oneBall() {
        String[] inputs = {"891", "837", "592"};
        for (String input : inputs) {
            players.initializeUserNumbersWith(input);
            answerChecker.calculateResult();
            answerChecker.printResult();
            assertEquals("1볼", outputStreamCaptor.toString().trim());
            outputStreamCaptor.reset();
            answerChecker.clear();
        }
    }

    @DisplayName("2볼")
    @Test
    void twoBall() {
        String[] inputs = {"712", "361", "234"};
        for (String input : inputs) {
            players.initializeUserNumbersWith(input);
            answerChecker.calculateResult();
            answerChecker.printResult();
            assertEquals("2볼", outputStreamCaptor.toString().trim());
            outputStreamCaptor.reset();
            answerChecker.clear();
        }
    }

    @DisplayName("3볼")
    @Test
    void threeBall() {
        String[] inputs = {"231", "312"};
        for (String input : inputs) {
            players.initializeUserNumbersWith(input);
            answerChecker.calculateResult();
            answerChecker.printResult();
            assertEquals("3볼", outputStreamCaptor.toString().trim());
            outputStreamCaptor.reset();
            answerChecker.clear();
        }
    }

    @DisplayName("낫싱")
    @Test
    void nothing() {
        String[] inputs = {"958", "756", "549"};
        for (String input : inputs) {
            players.initializeUserNumbersWith(input);
            answerChecker.calculateResult();
            answerChecker.printResult();
            assertEquals("낫싱", outputStreamCaptor.toString().trim());
            outputStreamCaptor.reset();
            answerChecker.clear();
        }
    }
}
