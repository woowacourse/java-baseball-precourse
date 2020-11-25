package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        GameManager gameManager = new GameManager();
        System.out.println(gameManager.getAnswer());
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            ArrayList<Integer> userAnswer = gameManager.requestAnswer(scanner);
            if (gameManager.checkAnswer(userAnswer)) {
                System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", GameManager.NUMBER_ANSWER);
                break;
            }
        }
    }
}
