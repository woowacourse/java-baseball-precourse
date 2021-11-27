package baseball.view;

import baseball.domain.vo.JudgementResult;

public class OutputView {

    public void printResult(JudgementResult result) {
        System.out.println(result);
    }

    public void gameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
