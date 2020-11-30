package baseball;

import java.util.Scanner;

public class GameManager {

    private final Scanner scanner;
    private static final String CONTINUE = "1";
    private static final String QUIT = "2";

    public GameManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startGame() {
        do {
            game();
        } while (continueGame());
    }

    private void game() {
        Balls botBalls;
        GameResult gameResult;

        botBalls = Balls.generateRandomBalls();                 // 랜덤 생성 수
        do {
            System.out.println(botBalls);// TODO 테스트

            System.out.print("숫자를 입력해주세요 : ");
            gameResult = getMyBalls().judgeResult(botBalls);    // 사용자 수 입력 & 결과 계산
            printResult(gameResult);                            // 결과 출력

        } while (!gameResult.isAllStrikes());                   // 3스트라이크: 루프탈출
    }

    private void printResult(GameResult gameResult) {
        System.out.println(gameResult.getResult());
    }

    private Balls getMyBalls() {
        Balls myBalls = null;
        while (myBalls == null) {
            try {
                myBalls = Balls.stringToBalls(scanner.next());  // 사용자 생성 balls
            } catch (NumberFormatException e) {
                System.out.println("3개의 1~9 사이의 수만 입력할 수 있습니다.");
            }
        }
        return myBalls;
    }

    private Boolean continueGame() {
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = scanner.next().trim();

            if (!input.equals(CONTINUE) && !input.equals(QUIT)) {
                System.out.println("1, 2만 입력 가능합니다. 다시 입력해주세요. 입력값:" + input);
                continue;
            }

            return input.equals(CONTINUE);
        }
    }
}