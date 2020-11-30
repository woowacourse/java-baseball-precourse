package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import utils.RandomUtils;
import views.OutputView;

public class Game {

    private static final long WINNING_STRIKE_CONDITION = 3;
    private static final int MAXIMUM_BALL_VALUE = 9;
    private static final int MINIMUM_BALL_VALUE = 1;
    private final Scanner userInput;
    private Baseballs answerBalls;
    private Baseballs guessingBalls;
    private Status gameStatus;

    public Game(Scanner userInput) {
        this.userInput = userInput;
    }

    public void play() {
        initialize();
        while (gameStatus.getStrikeCount() != WINNING_STRIKE_CONDITION) {
            proceedRound();
        }
        OutputView.congratulateWin();
    }

    private void initialize() {
        gameStatus = new Status();
        generateAnswerBalls();
    }

    private void proceedRound() {
        generateGuessingBalls();
        gameStatus.check(answerBalls, guessingBalls);
        OutputView.printStatus(gameStatus.getBallCount(), gameStatus.getStrikeCount());
    }

    private void generateAnswerBalls() {
        answerBalls = new Baseballs(createNonDuplicateNumbers(Baseballs.BALLS_CONTAINER_SIZE));
    }

    private List<Integer> createNonDuplicateNumbers(int size) {
        List<Integer> generatedNumbers = new ArrayList<>(createNumberSet(size));
        Collections.shuffle(generatedNumbers);
        return generatedNumbers;
    }

    private Set<Integer> createNumberSet(int ballsContainerSize) {
        Set<Integer> generatedNumbers = new HashSet<>();
        while (generatedNumbers.size() != ballsContainerSize) {
            generatedNumbers.add(RandomUtils.nextInt(MINIMUM_BALL_VALUE, MAXIMUM_BALL_VALUE));
        }
        return generatedNumbers;
    }

    private void generateGuessingBalls() {
        try {
            OutputView.askPlayerNumbers();
            guessingBalls = new Baseballs(userInput.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            generateGuessingBalls();
        }
    }
}
