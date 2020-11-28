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
    private Scanner userInput;
    private Baseballs answerBalls;
    private Baseballs guessingBalls;

    public Game(Scanner userInput) {
        this.userInput = userInput;
    }

    public void play() {
        initialize();
        proceedRound();
    }

    private void initialize() {
        generateAnswerBalls();
        System.out.println(answerBalls.getBalls());
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
        while(generatedNumbers.size() != ballsContainerSize) {
            generatedNumbers.add(RandomUtils.nextInt(1, 9));
        }
        return generatedNumbers;
    }

    private void proceedRound() {
        OutputView.askPlayerNumbers();
        guessingBalls = new Baseballs(userInput.nextLine());
        System.out.println(guessingBalls.getBalls());
    }


}
