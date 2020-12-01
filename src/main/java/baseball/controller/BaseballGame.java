/**
 * BaseballGame.java
 * 한 판의 게임 진행 로직을 관장하는 클래스
 *
 * @author Kimun Kim / kkm97351@gmail.com
 */

package baseball.controller;

import baseball.model.BallCount;
import baseball.model.Numbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {
    private static final int MAX_STRIKE = Numbers.NUMBERS_LENGTH;

    private final Numbers answer;

    private BaseballGame(Numbers answer) {
        this.answer = answer;
    }

    /* 정답이 될 Numbers 객체를 받아 하나의 게임을 생성하는 메소드 */
    public static BaseballGame createNewGame(Numbers answer) {
        return new BaseballGame(answer);
    }

    /* 게임 진행 로직 */
    public void play() {
        BallCount ballCount;
        do {
            Numbers userNumbers = getNumbersFromUser();
            ballCount = answer.calculateBallCountWith(userNumbers);
            OutputView.showBallCount(ballCount);
        } while (ballCount.getStrike() != MAX_STRIKE);

        OutputView.showWinningMessage();
    }

    /* 유저에게 숫자 입력을 요청하고 Numbers를 리턴. 예외 입력에 대해 재입력 요구 */
    private Numbers getNumbersFromUser() {
        try {
            return Numbers.valueOf(InputView.getNumbers());
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e.getMessage());
            return getNumbersFromUser();
        }
    }
}
