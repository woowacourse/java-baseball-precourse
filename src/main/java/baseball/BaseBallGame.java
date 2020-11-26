package baseball;

import baseball.domain.Ball;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static baseball.domain.Number.*;
import static utils.InputValidation.validateSelectGameStatus;

public class BaseBallGame {

    public int play(Scanner sc) {
        Ball ball = new Ball();
        List<Integer> computer = ball.computerBallGenerator();
        while (true) {
            List<Integer> user = ball.userBallGenerator(sc);
            if(compareBall(computer, user)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                return selectGameStatus(sc);
            }
        }
    }

    private int selectGameStatus(Scanner sc) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int status = sc.nextInt();
        validateSelectGameStatus(status);
        return status;
    }

    private boolean compareBall(List<Integer> computer, List<Integer> user) {
        int strikeCount = calculateStrike(computer, user);
        int ballCount = calculateBall(computer, user);
        printGameResult(strikeCount, ballCount);
        return (strikeCount == GAME_END);
    }

    private int calculateStrike(List<Integer> computer, List<Integer> user) {
        return (int) IntStream.range(0, NUMBER_COUNT)
                .filter(i -> computer.get(i).equals(user.get(i)))
                .count();
    }

    private int calculateBall(List<Integer> computer, List<Integer> user) {
        return (int) IntStream.range(0, NUMBER_COUNT)
                .filter(i -> (!computer.get(i).equals(user.get(i))) &&
                        computer.contains(user.get(i)))
                .count();
    }

    private void printGameResult(int strikeCount, int ballCount) {
        String message = "";
        if(strikeCount != NUMBER_RANGE_ZERO) {
            message += strikeCount+"스트라이크 ";
        }
        if(ballCount != NUMBER_RANGE_ZERO) {
            message += ballCount+"볼 ";
        }
        if(message.length() == NUMBER_RANGE_ZERO) {
            message += "낫싱";
        }
        System.out.println(message);
    }
}
