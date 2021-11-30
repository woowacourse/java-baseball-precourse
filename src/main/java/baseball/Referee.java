package baseball;

import java.util.List;

public class Referee {
    Integer strike;
    Integer ball;
    List<Integer> computerDeck;
    StringBuilder result;

    public Referee(List<Integer> computerDeck) {

        this.computerDeck = computerDeck;}

    public void judgePlayerDeck(List<Integer> playerExpectDeck) {

        strike = 0;
        ball = 0;
        countBallsAndStrikes(playerExpectDeck);
        callResult();
    }

    private void countBallsAndStrikes(List<Integer> playerExpectDeck) {

        for (int i = 0; i < 3; i++) {
            Integer playerExpectedNumber = playerExpectDeck.get(i);
            Integer computerNumber = computerDeck.get(i);
            if (countStrikes(playerExpectedNumber, computerNumber)) {
                continue;
            }
            countBalls(playerExpectedNumber);
        }
    }

    private void callResult() {

        result = new StringBuilder();
        appendBalls();
        appendStrikes();
        checkNothing();

        System.out.println(result);
    }

    private void appendBalls() {
        if (!ball.equals(0)) {

            result.append(ball).append("볼 ");
        }
    }

    private void appendStrikes() {

        if (!strike.equals(0)) {
            result.append(strike).append("스트라이크");
        }
    }

    private void checkNothing() {
        if (result.length() == 0) {
            result.append("낫싱");
        }
    }


    private boolean countStrikes(Integer playerExpectedNumber, Integer computerNumber) {
        if (playerExpectedNumber.equals(computerNumber)) {
            strike++;
            return true;
        }
        return false;
    }

    private void countBalls(Integer playerExpectedNumber) {
        if (computerDeck.contains(playerExpectedNumber)) {
            ball++;
        }
    }
}
