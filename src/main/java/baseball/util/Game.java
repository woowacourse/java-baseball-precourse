package baseball.util;

import baseball.domain.GameBalls;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    public Game() {
        while (true) {
            GameBalls computer = new GameBalls();
            guessComputerBalls(computer);

            GameGuidePrinter.gameFinish();
            GameGuidePrinter.gameStartAgain();
            String gameOperator = Console.readLine();
            
            if (gameOperator.equals("1")) {
                continue;
            } else if (gameOperator.equals("2")) {
                break;
            } else {
                throw new IllegalArgumentException("1 또는 2를 입력하세요");
            }
        }
    }

    private void guessComputerBalls(GameBalls computer) {
        String prediction = "";

        while (!prediction.equals("3스트라이크")) {
            GameBalls balls = getUserInputBalls();
            GameBallComparator comparator = new GameBallComparator(balls, computer);

            prediction = comparator.gameResult();
            GameGuidePrinter.gameResult(prediction);
        }
    }


    private GameBalls getUserInputBalls() {
        GameGuidePrinter.inputUserNumber();
        String userNumber = Console.readLine();
        GameBalls balls = new GameBalls(userNumber);
        return balls;
    }
}
