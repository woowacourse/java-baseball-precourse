package baseball;

import java.util.ArrayList;

public class GameReferee {
    private static final int LENGTH = 3;
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String WIN = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private ArrayList<Integer> computerNumberList;
    private ArrayList<Integer> userNumberList;
    private String resultMessage;
    private int ballCount;
    private int strikeCount;

    public boolean decideRefereeResult(ArrayList<Integer> computerNumberList, ArrayList<Integer> userNumberList) {
        this.initializeReferee(computerNumberList, userNumberList);
        this.countStrikeAndBall();
        this.createResultMessage();
        System.out.println(resultMessage);
        return this.makeDecisionWinOrLose();
    }

    private boolean makeDecisionWinOrLose() {
        if (strikeCount == LENGTH) {
            System.out.println(WIN);
            return true;
        }
        return false;
    }

    private void initializeReferee(ArrayList<Integer> computerNumberList, ArrayList<Integer> userNumberList) {
        this.computerNumberList = computerNumberList;
        this.userNumberList = userNumberList;
        this.ballCount = 0;
        this.strikeCount = 0;
        this.resultMessage = "";
    }

    private boolean isStrike(int index) {
        if (computerNumberList.get(index) == userNumberList.get(index)) {
            strikeCount++;
            return true;
        }
        return false;
    }

    private void isBall(int index) {
        if (computerNumberList.contains(userNumberList.get(index))) {
            ballCount++;
        }
    }

    private void countStrikeAndBall() {
        for (int index = 0; index < LENGTH; index++) {
            if (!this.isStrike(index)) {
                this.isBall(index);
            }
        }
    }

    private void createResultMessage() {
        if (ballCount == 0 && strikeCount == 0) {
            resultMessage += NOTHING;
            return;
        }
        if (ballCount != 0 && strikeCount != 0) {
            resultMessage += ballCount + BALL + " " + strikeCount + STRIKE;
            return;
        }
        if (ballCount != 0 && strikeCount == 0) {
            resultMessage += ballCount + BALL;
            return;
        }
        if (ballCount == 0 && strikeCount != 0) {
            resultMessage += strikeCount + STRIKE;
            return;
        }
    }

}
