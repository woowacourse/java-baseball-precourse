package baseball.view;

import baseball.model.Result;

public class OutputView {

    private OutputView() {
    }

    public static void printResult(Result result) {
        int strikeCount = result.fetchStrikeCount();
        int ballCount = result.fetchBallCount();

        if (result.hasNoCounts()) {
            System.out.println("낫싱");
            return;
        }

        if (result.hasOnlyBall()) {
            System.out.printf("%d볼%n", ballCount);
            return;
        }

        if (result.hasOnlyStrike()) {
            System.out.printf("%d스트라이크%n", strikeCount);

            if (result.isGameOver()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }

            return;
        }

        System.out.printf("%d볼 %d스트라이크%n", ballCount, strikeCount);
    }
}

