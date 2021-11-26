package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 숫자 야구 게임을 진행하는 클래스
 * 사용자가 입력한 수와 컴퓨터의 수를 비교하여 힌트를 제공한다.
 * 3스트라이크일 경우, 재시작 여부를 묻는다.
 * <p>
 * 재시작 여부를 입력받고, 올바른 입력이 아닐 경우 예외처리를,
 * 올바른 입력이면 그 입력대로 수행한다.
 */
public class Game {
    static final String RESTART = "1";
    static final String EXIT = "2";
    static final int BALL_SIZE = 3;

    static final String BALL_HINT_MESSAGE = "볼 ";
    static final String STRIKE_HINT_MESSAGE = "스트라이크";
    static final String NOTHING_HINT_MESSAGE = "낫싱";
    static final String VICTORY_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private BallInputNumber ballInputNumber;
    private ComputerNumber computerNumber;

    private List<Integer> inputNumberList;
    private List<Integer> answerNumberList;
    private int strike;
    private int ball;

    public Game() {
        computerNumber = new ComputerNumber();
        ballInputNumber = new BallInputNumber();

        inputNumberList = new ArrayList<>();
        answerNumberList = computerNumber.getComputerNumber();
        strike = 0;
        ball = 0;
    }

    public void playBaseball() {
        do {
            inputNumberList = ballInputNumber.inputNumberByClient();
            strike = 0;
            ball = 0;
            getScore();
            getHint();
        } while (!isFinish());
    }

    public void getHint() {
        if (ball > 0) {
            System.out.print(ball + BALL_HINT_MESSAGE);
        }
        if (strike > 0) {
            System.out.println(strike + STRIKE_HINT_MESSAGE);
        }
        if (strike == 3) {
            System.out.println(VICTORY_MESSAGE);
        }
        if (ball + strike == 0) {
            System.out.println(NOTHING_HINT_MESSAGE);
        }
    }

    public void getScore() {
        String inputString = inputNumberList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        String answerString = answerNumberList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        for (int i = 0; i < BALL_SIZE; i++) {
            int index = inputString.indexOf(answerString.charAt(i));
            if (index == i) {
                strike++;
            } else if (index != -1) {
                ball++;
            }
        }
    }

    public boolean isFinish() {
        return strike == 3;
    }

    public boolean askRestart() {
        System.out.println(RESTART_MESSAGE);
        String isRestart = Console.readLine();

        if (!RestartNumberValidator.rightInputRestartCheck(isRestart)) {
            throw new IllegalArgumentException();
        }
        return isRestart.equals(RESTART);
    }
}
