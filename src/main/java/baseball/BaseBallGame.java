package baseball;

import java.util.Scanner;

public class BaseBallGame {

    private final Scanner scanner;
    private static final String CONTINUE = "1";
    private static final String QUIT = "2";

    public BaseBallGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        do {
            singleGame();
        } while (continueGame());
        scanner.close();
    }

    private void singleGame() {
        Balls botBalls;
        GameResult gameResult;

        botBalls = Balls.generateRandomBalls();                 // 랜덤 생성 수
        do {
            System.out.println(botBalls);// TODO 테스트

            System.out.print("숫자를 입력해주세요 : ");
            gameResult = getUserBalls().judgeResult(botBalls);  // 사용자 수 입력 & 결과 계산
            printResult(gameResult);                            // 결과 출력
        } while (!gameResult.isAllStrikes());                   // 3스트라이크: 루프탈출
    }

    private void printResult(GameResult gameResult) {
        System.out.println(gameResult.getResultMessage());
    }

    private Balls getUserBalls() {
        Balls userBalls = null;
        while (userBalls == null) {
            try {
                userBalls = Balls.stringToBalls(getInputString());  // 사용자 생성 balls
            } catch (NumberFormatException e) {
                System.out.println("3개의 1~9 사이의 수만 입력할 수 있습니다.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return userBalls;
    }

    private Boolean continueGame() {
        String input;
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = getInputString();

            if (!input.equals(CONTINUE) && !input.equals(QUIT)) {
                System.out.println("1, 2만 입력 가능합니다. 다시 입력해주세요. 입력값:" + input);
                continue;
            }

            return input.equals(CONTINUE);
        }
    }

    private String getInputString() {
        return scanner.nextLine();
    }
}