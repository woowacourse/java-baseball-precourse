package baseball;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static baseball.domain.Number.*;

public class BaseBallGame {

    private int selectGameStatus(Scanner sc) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return sc.nextInt();
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
