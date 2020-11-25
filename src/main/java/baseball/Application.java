package baseball;

import java.util.ArrayList;
import java.util.Scanner;
import baseball.GameManager.GameStatus;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        GameManager gameManager = new GameManager();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            ArrayList<Integer> userAnswer = gameManager.requestAnswer(scanner);
            if (!gameManager.checkAnswer(userAnswer)) {
                continue;
            }
            System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", GameManager.NUMBER_ANSWER);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int gameStatus = gameManager.requestReplay(scanner);
            if (gameStatus == GameStatus.END.getValue()) {
                break;
            } else if (gameStatus == GameStatus.RESTART.getValue()) {
                gameManager.generateAnswer();
            }
        }
    }
}
