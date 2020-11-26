package baseball.game;

import static baseball.checker.NumberChecker.*;

import baseball.players.Players;
import baseball.players.User;
import baseball.checker.AnswerChecker;
import java.util.Scanner;

public class GameManager {
    private final Players players;
    private final AnswerChecker answerChecker;

    public GameManager(Scanner scanner) {
        this.players = new Players(scanner);
        this.answerChecker = new AnswerChecker(players);
    }

    public void start() {
        players.generateComputerNumber();
        User user = players.getUser();
        do {
            answerChecker.clearUserNumbersAndResult();
            user.getUserInput();
            answerChecker.calculateResult();
            answerChecker.printResult();
        } while (!answerChecker.isAnswer());
        printCorrectionAndEndingMessage();
    }

    private void printCorrectionAndEndingMessage() {
        System.out.println(BASEBALL_NUMBERS_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean isContinue() {
        return players.getUser().isUserWantToContinue();
    }
}
