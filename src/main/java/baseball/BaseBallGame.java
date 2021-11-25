package baseball;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class BaseBallGame {

    public static final int NUMBER_LENGTH = 3;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int REPLAYING_NUMBER = 1;
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String GAME_CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String REPLAYING_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final Player player;
    private List<Integer> targetNumber;

    public BaseBallGame() {
        player = new Player();
        startGame();
    }

    private void startGame() {
        targetNumber = getTargetNumber();
        playGame();
        checkReplaying();
    }

    private List<Integer> getTargetNumber() {
        Set<Integer> result = new LinkedHashSet<>();
        while (result.size() < NUMBER_LENGTH) {
            result.add(pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
        }
        return new ArrayList<>(result);
    }

    private void playGame() {
        List<Integer> playerNumber = player.getPlayerNumber();
        while (!isThreeStrike(playerNumber)) {
            checkBallAndStrike(playerNumber);
            playerNumber = player.getPlayerNumber();
        }
        printClearMessage();
    }

    private boolean isThreeStrike(List<Integer> playerNumber) {
        return targetNumber.equals(playerNumber);
    }

    private void printClearMessage() {
        System.out.println(NUMBER_LENGTH + STRIKE_MESSAGE);
        System.out.println(GAME_CLEAR_MESSAGE);
        System.out.println(REPLAYING_OR_END_MESSAGE);
    }
    
    private void checkBallAndStrike(List<Integer> playerNumber) {
        int strike = countStrike(playerNumber);
        int ball = countBall(playerNumber, strike);
        System.out.println(getBallAndStrikeMessage(ball, strike));
    }

    private int countStrike(List<Integer> playerNumber) {
        int strike = (int) IntStream.range(0, NUMBER_LENGTH - 1)
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
            return NOTHING_MESSAGE;
        }
        return result;
    }

    private String getBallMessage(int ball) {
        if (ball > 0) {
            return String.format("%d%s ", ball, BALL_MESSAGE);
        }
        return "";
    }

    private String getStrikeMessage(int strike) {
        if (strike > 0) {
            return String.format("%d%s", strike, STRIKE_MESSAGE);
        }
        return "";
    }

    private void checkReplaying() {
        int replayingOrEndNumber = player.getReplayingOrEndNumber();
        if (replayingOrEndNumber == REPLAYING_NUMBER) {
            startGame();
        }
    }
}
