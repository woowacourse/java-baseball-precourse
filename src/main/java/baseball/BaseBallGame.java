package baseball;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class BaseBallGame {

    private static final int NUMBER_LENGTH = 3;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int REPLAY = 1;
    private static int REPLAY_OR_END = 1;
    private final List<Integer> targetNumber;
    private final Player player;

    public BaseBallGame() {
        targetNumber = makeRandomNumber();
        player = new Player();
        startGame();
    }

    private List<Integer> makeRandomNumber() {
        Set<Integer> result = new LinkedHashSet<>();
        while (result.size() < NUMBER_LENGTH) {
            result.add(pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
        }
        return new ArrayList<>(result);
    }

    private void startGame() {
        playGame();
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        checkReplay();
    }

    private void playGame() {
        List<Integer> playerNumber = player.getPlayerNumber();
        while (!isThreeStrike(playerNumber)) {
            checkBallAndStrike(playerNumber);
            playerNumber = player.getPlayerNumber();
        }
    }

    private boolean isThreeStrike(List<Integer> playerNumber) {
        return targetNumber.equals(playerNumber);
    }

    private void checkBallAndStrike(List<Integer> playerNumber) {
        int strike = countStrike(playerNumber);
        int ball = countBall(playerNumber, strike);
        System.out.println(getBallAndStrikeMessage(ball, strike));
    }

    private int countStrike(List<Integer> playerNumber) {
        int strike = (int) IntStream.range(0, playerNumber.size())
                .filter(i -> targetNumber.get(i).equals(playerNumber.get(i)))
                .count();
        return strike;
    }

    private int countBall(List<Integer> playerNumber, int strike) {
        int ball = (int) playerNumber.stream()
                .filter(targetNumber::contains)
                .count() - strike;
        return ball;
    }

    private String getBallAndStrikeMessage(int ball, int strike) {
        String ballMessage = getBallMessage(ball);
        String strikeMessage = getStrikeMessage(strike);
        String result = ballMessage + strikeMessage;
        if (result.equals("")) {
            return "낫싱";
        }
        return result;
    }

    private String getBallMessage(int ball) {
        if (ball > 0) {
            return String.format("%d볼 ", ball);
        }
        return "";
    }

    private String getStrikeMessage(int strike) {
        if (strike > 0) {
            return String.format("%d스트라이크", strike);
        }
        return "";
    }

    private void checkReplay() {
        REPLAY_OR_END = player.getReplayOrEndNumber();
        if (REPLAY_OR_END == REPLAY) {
            new BaseBallGame();
        }
    }
}
