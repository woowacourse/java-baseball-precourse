package baseball;

import baseball.domain.Ball;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static baseball.domain.GameInfomation.*;
import static utils.InputValidation.validateSelectGameStatus;

public class BaseBallGame {

    public int play(Scanner sc) {
        Ball ball = new Ball();
        List<Integer> computer = ball.getComputerBall();
        while (true) {
            List<Integer> user = ball.getUserBall(sc);
            if(isGameEnd(computer, user)) {
                System.out.println(GAME_END_MESSAGE);
                return selectGameStatus(sc);
            }
        }
    }

    private int selectGameStatus(Scanner sc) {
        System.out.println(SELECT_GAME_STATUS_MESSAGE);
        int status = sc.nextInt();
        validateSelectGameStatus(status);
        return status;
    }

    private boolean isGameEnd(List<Integer> computer, List<Integer> user) {
        int strikeCount = calculateStrike(computer, user);
        int ballCount = calculateBall(computer, user);
        printGameResult(strikeCount, ballCount);
        return (strikeCount == GAME_END);
    }

    private int calculateStrike(List<Integer> computer, List<Integer> user) {
        return (int) IntStream.range(0, NUMBER_LENGTH)
                .filter(i -> computer.get(i).equals(user.get(i)))
                .count();
    }

    private int calculateBall(List<Integer> computer, List<Integer> user) {
        return (int) IntStream.range(0, NUMBER_LENGTH)
                .filter(i -> (!computer.get(i).equals(user.get(i))) &&
                        computer.contains(user.get(i)))
                .count();
    }

    private void printGameResult(int strikeCount, int ballCount) {
        String message = "";
        if(ballCount != NUMBER_RANGE_ZERO) {
            message += (ballCount + BALL);
        }
        if(strikeCount != NUMBER_RANGE_ZERO) {
            message += (strikeCount + STRIKE);
        }
        if(message.length() == NUMBER_RANGE_ZERO) {
            message += NOTHING;
        }
        System.out.println(message);
    }
}
