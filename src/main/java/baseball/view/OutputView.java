package baseball.view;

import static baseball.controller.GameController.EXIT_NUMBER;
import static baseball.controller.GameController.RESTART_NUMBER;
import static baseball.domain.RandomNumbers.NUMBER_LIST_SIZE;

/**
 * 출력을 담당하는 클래스
 *
 * @author 조연우
 * @version 1.0 2020년 11월 25일
 */
public class OutputView {
    private static final int NOTHING = 0;
    private static final String PRINT_BALL = "볼 ";
    private static final String PRINT_STRIKE = "스트라이크 ";
    private static final String PRINT_NOTHING = "낫싱";

    public void printResult(int balls, int strikes) {
        if (balls == NOTHING && strikes == NOTHING) {
            System.out.println(PRINT_NOTHING);
        } else if (strikes == NUMBER_LIST_SIZE) {
            System.out.println(strikes + PRINT_STRIKE);
            System.out.println(strikes + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (balls == NOTHING) {
            System.out.println(strikes + PRINT_STRIKE);
        } else if (strikes == NOTHING) {
            System.out.println(balls + PRINT_BALL);
        } else {
            System.out.println(balls + PRINT_BALL + strikes + PRINT_STRIKE);
        }
    }

    public void printRestart() {
        System.out.println("게임을 새로 시작하려면 " + RESTART_NUMBER + ", 종료하려면 " + EXIT_NUMBER + "를 입력하세요.");
    }
}
