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
        int[] computerPlayerRecords = playerComputer.getRecords();
        printArray(computerPlayerRecords);
        do {
            int[] humanPlayerRecords = playerHuman.getRecords(scanner);
            judge.compareRecords(humanPlayerRecords, computerPlayerRecords);
        } while(!judge.isPlayerCorrectAll());
    }

    public boolean askPlayerAnswerOfRestartGame() {
        return false;
    }

    public static void printArray(int[] array){
        for(int i:array)
            System.out.printf("%d ", i);
        System.out.println();
    }
}
