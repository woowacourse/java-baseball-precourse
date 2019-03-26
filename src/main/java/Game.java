import java.util.Scanner;

public class Game {
    private GamePlay gamePlay;

    public GamePlay getGamePlay() {
        return gamePlay;
    }

    public void startGame(Scanner sc) {
        gamePlay = new GamePlay();
        gamePlay.init();
        processingGame(sc);
    }

    private void processingGame(Scanner sc) {
        gamePlay.requestInputMessage();
        gamePlay.getUserInput(sc.nextLine().split(""));
        gamePlay.countResult();
        gamePlay.printGameResult();
    }

    public boolean continueGame(Scanner sc) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = sc.nextInt();
        return !(input == 2) ;
    }
}
