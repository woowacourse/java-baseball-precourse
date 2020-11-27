package baseball;

import java.util.Scanner;

public class GameManager {
    final Scanner scanner;

    static final String CONTINUE = "1";
    static final String QUIT = "2";

    public GameManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void game() {
        do {
            gaming();
        } while (continueGame());
    }

    private void gaming() {
        Balls botBalls;
        Balls myBalls;
        GameResult gameResult;

        do {
            botBalls = Balls.generateRandomBalls();         // 랜덤 생성 balls
            myBalls = getMyBalls();
            gameResult = myBalls.judgeResult(botBalls);     // 결과 계산
            gameResult.printResult();

        } while (!gameResult.isThreeStrikes());             // 3스트라이크: 루프탈출
    }

    private Balls getMyBalls() {
        Balls myBalls = null;
        while (myBalls == null) {
            try {
                myBalls = Balls.stringToBalls(scanner.next());  // 사용자 생성 balls
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return myBalls;
    }

    private Boolean continueGame() {
        String s = scanner.next();
        if (s.equals(CONTINUE)) {
            return true;
        } else if (s.equals(QUIT)) {
            return false;
        }
        return false;
//        return GameStatus.valueOf(s).isContinue();
    }
}

enum GameStatus {
    CONTINUE("1"),
    QUIT("2");

    String input;

    GameStatus(String input) {
        this.input = input;
    }

    Boolean isContinue() {
        if (this == GameStatus.CONTINUE) {
            return true;
        } else if (this == GameStatus.QUIT) {
            return false;
        }

        return false;
    }
}