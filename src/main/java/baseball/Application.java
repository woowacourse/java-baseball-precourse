package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        GameManager gameManager = new GameManager();
        while (gameManager.getGameStatus() == GameStatus.ONGOING) {
            System.out.print("숫자를 입력해주세요 : ");
            ArrayList<Integer> userAnswer = GameManager.requestUserAnswer(scanner);
            GameResult gameResult = gameManager.checkAnswer(userAnswer);
            gameResult.printResult();
            if (gameManager.getGameStatus() == GameStatus.WAIT) {
                System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", GameManager.NUMBER_ANSWER);
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                gameManager.requestReplay(scanner);
            }
        }
    }
}
