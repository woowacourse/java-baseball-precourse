package baseball;


import java.util.Scanner;

public class GameManager {

    private final PlayerHuman playerHuman;
    private final PlayerComputer playerComputer;
    private final Judge judge;

    public GameManager() {
        playerHuman = new PlayerHuman();
        playerComputer = new PlayerComputer();
        judge = new Judge();
    }

    public void gameStart(Scanner scanner) {
        String computerPlayerRecords = playerComputer.getRecords();
        do {
            String humanPlayerRecords = playerHuman.getRecords(scanner);
            // 심판이 비교 후 결과(힌트) 출력
            judge.compareRecords(humanPlayerRecords, computerPlayerRecords);
        } while(!judge.askPlayerCorrectAll());
    }

    public boolean askPlayerAnswerOfRestartGame() {
    }
}
