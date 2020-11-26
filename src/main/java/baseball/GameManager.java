package baseball;

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
            user.getUserInput();
            Result result = answerChecker.calculateResult(players);
            result.printResult();
            result.clearResult();
            user.getNumbers().clear();
        } while (!answerChecker.isAnswer());
    }

    public boolean isContinue() {
        // TODO : return user.isContinue();
        return false;
    }
}
