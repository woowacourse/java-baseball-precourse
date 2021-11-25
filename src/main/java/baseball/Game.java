package baseball;

import java.util.List;

/**
 * 숫자 야구 게임을 진행하는 클래스
 * 사용자가 입력한 수와 컴퓨터의 수를 비교하여 힌트를 제공한다.
 * 3스트라이크일 경우, 재시작 여부를 묻는다.
 * <p>
 * 재시작 여부를 입력받고, 올바른 입력이 아닐 경우 예외처리를,
 * 올바른 입력이면 그 입력대로 수행한다.
 */
public class Game {
    private List<Integer> inputNumberList;
    private List<Integer> answerNumberList;

    public Game() {
        BallInputNumber ballInputNumber = new BallInputNumber();
        ComputerNumber computerNumber = new ComputerNumber();

        inputNumberList = ballInputNumber.getClientNumber();
        answerNumberList = computerNumber.getComputerNumber();
    }
}
