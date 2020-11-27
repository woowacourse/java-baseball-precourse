package baseball.game;

import static baseball.checker.NumberChecker.*;

import baseball.players.Players;
import baseball.checker.AnswerChecker;
import java.util.Scanner;

public class GameManager {
    private static final String CORRECT_ENDING_MESSAGE = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final Players players;
    private final AnswerChecker answerChecker;

    public GameManager(Scanner scanner) {
        this.players = new Players(scanner);
        this.answerChecker = new AnswerChecker(players);
    }

    public void start() {
        players.generateComputerNumber();
        do {
            initializeGame();
            playGame();
        } while (!answerChecker.isAnswer());
        printCorrectionAndEndingMessage();
    }

    private void playGame() {
        players.userInput();
        answerChecker.calculateResult();
        answerChecker.printResult();
    }

    private void initializeGame() {
        answerChecker.clear();
        players.clearUserNumbers();
    }

    private void printCorrectionAndEndingMessage() {
        System.out.println(NUMBERS_SIZE + CORRECT_ENDING_MESSAGE);
    }

    public boolean isContinue() {
        return players.isUserWantToContinue();
    }
}
