package view;

import model.BallCount;

public class OutputView {
    private StringBuilder result;

    public void showResult(final BallCount ballCount) {
        result = new StringBuilder();
        checkNothing(ballCount);
        checkBall(ballCount);
        checkStrike(ballCount);
        System.out.println(result);
    }

    private void checkNothing(final BallCount ballCount) {
        if (ballCount.isNothing()) {
            result.append("낫싱 ");
        }
    }

    private void checkStrike(final BallCount ballCount) {
        if (ballCount.getStrike() != 0) {
            result.append(ballCount.getStrike()).append("스트라이크 ");
        }
    }

    private void checkBall(final BallCount ballCount) {
        if (ballCount.getBall() != 0) {
            result.append(ballCount.getBall()).append("볼 ");
        }
    }

    public void showGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
