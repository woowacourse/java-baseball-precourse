package baseball;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class BaseBallGame {

    private static final int NUMBER_LENGTH = 3;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static int REPLAY_OR_END = 1;
    private static int REPLAY = 1;
    private static int EMD = 2;
    private final List<Integer> targetNumber;
    private final Player player;

    public BaseBallGame() {
        targetNumber = makeRandomNumber();
        player = new Player();
        gameStart();
    }

    private List<Integer> makeRandomNumber() {
        Set<Integer> result = new HashSet<>();
        while (result.size() < NUMBER_LENGTH) {
            result.add(pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
        }
        return shuffle(new ArrayList<>(result));
    }

    private void gameStart() {
        List<Integer> playerNumber = player.playerNumber();
        while (!threeStrike(playerNumber)) {
            ballAndStrike(playerNumber);
            playerNumber = player.playerNumber();
        }
        gameEnd();
    }

    private boolean threeStrike(List<Integer> playerNumber) {
        return targetNumber.equals(playerNumber);
    }

    private void ballAndStrike(List<Integer> playerNumber) {
        int strike = strikeCount(playerNumber);
        int ball = ballCount(playerNumber, strike);
        System.out.println(printBallAndStrike(ball, strike));
    }

    private int strikeCount(List<Integer> playerNumber) {
        int strike = (int) IntStream.range(0, playerNumber.size())
                .filter(i -> targetNumber.get(i).equals(playerNumber.get(i)))
                .count();
        return strike;
    }

    private int ballCount(List<Integer> playerNumber, int strike) {
        int ball = (int) playerNumber.stream()
                .filter(targetNumber::contains)
                .count() - strike;
        return ball;
    }

    private String printBallAndStrike(int ball, int strike) {
        String printBall = "";
        String printStrike = "";
        if (ball > 0) {
            printBall = String.format("%d볼 ", ball);
        }
        if (strike > 0) {
            printStrike = String.format("%d스트라이크", strike);
        }
        String result = printBall + printStrike;
        if (result.equals("")) {
            return "낫싱";
        }
        return result;
    }

    private void gameEnd() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        checkReplay();
    }

    private void checkReplay() {
        REPLAY_OR_END = player.replayOrEndNumber();
        if (REPLAY_OR_END == REPLAY) {
            new BaseBallGame();
        }
    }
}
