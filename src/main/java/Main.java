import java.util.Scanner;

// 19-03-26 3차 리팩토링
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GamePlay gamePlay = new GamePlay();

        while (gamePlay.isContinueGame()) {
            gamePlay.init();
            gamePlay.requestInputMessage();
            gamePlay.getUserInput(sc.next().split(""));
            gamePlay.countResult();
            gamePlay.getGameResult().print();
            gamePlay.checkEndOrContinum(sc);
            gamePlay.getGameResult().initGameResult();
        }
    }
}
