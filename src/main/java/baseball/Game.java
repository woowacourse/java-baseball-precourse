package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
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
    static final String RESTART = "1";
    static final String EXIT = "2";
    static final int BALL_SIZE = 3;

    private BallInputNumber ballInputNumber;
    private ComputerNumber computerNumber;

    private List<Integer> inputNumberList;
    private List<Integer> answerNumberList;

    public Game() {
        computerNumber = new ComputerNumber();
        ballInputNumber = new BallInputNumber();

        inputNumberList = new ArrayList<>();
        answerNumberList = computerNumber.getComputerNumber();
    }

    public void playBaseball() {
        int ball = 0;
        int strike = 0;
        do {
            inputNumberList = ballInputNumber.inputNumberByClient();
            ball = getBall();
            strike = getStrike();
            getHint(ball, strike);
        } while (!isFinish(strike));
    }

    public void getHint(int ball, int strike) {
        boolean finish = false;
        if (ball > 0) {
            System.out.print(getBall() + "볼 ");
        }
        if (strike > 0) {
            System.out.println(getStrike() + "스트라이크");
        }
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            finish = true;
        }
        if (ball + strike == 0) {
            System.out.println("낫싱");
        }
    }

    public int getStrike() {
        int strike = 0;
        for (int i = 0; i < BALL_SIZE; i++) {
            if (inputNumberList.get(i) == answerNumberList.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    public int getBall() {
        String inputString = "";
        String answerString = "";
        int ball = 0;
        for (Integer number : inputNumberList) {
            inputString += number.toString();
        }
        for (Integer number : answerNumberList) {
            answerString += number.toString();
        }
        for (int i = 0; i < BALL_SIZE; i++) {
            int index = inputString.indexOf(answerString.charAt(i));
            if (index != i && index != -1) {
                ball++;
            }
        }
        return ball;
    }

    public boolean isFinish(int strike) {
        return strike == 3;
    }

    public boolean askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String isRestart = Console.readLine();

        if (!RestartNumberValidator.rightInputRestartCheck(isRestart)) {
            throw new IllegalArgumentException();
        }
        return isRestart.equals(RESTART);
    }
}
