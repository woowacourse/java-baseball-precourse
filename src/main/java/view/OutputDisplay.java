package view;

import logic.GameResultObject;

public class OutputDisplay {
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String END_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_PROMPT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    public void displayResult(GameResultObject gameResult) {
        System.out.println(getOutputMsg(gameResult));
    }

    private String getOutputMsg(GameResultObject gameResult) {
        int ballCount = gameResult.getBall();
        int strikeCount = gameResult.getStrike();

        if (ballCount > 0 && strikeCount > 0) {
            return ballCount + BALL + " " + strikeCount + STRIKE;
        }
        if (ballCount > 0) {
            return ballCount + BALL;
        }
        if (strikeCount > 0) {
            return strikeCount + STRIKE;
        }
        return NOTHING;
    }

    public void displayEndMsg() {
        System.out.println(END_MSG);
        System.out.println(RESTART_PROMPT);
    }
}
