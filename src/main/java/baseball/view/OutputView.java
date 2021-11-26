package baseball.view;

import baseball.domain.vo.BallStrikeCount;

public class OutputView {

    public void printResult(BallStrikeCount result) {
        System.out.println(result);
    }

    public void exitGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
