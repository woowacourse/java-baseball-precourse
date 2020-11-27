package baseball.generator;

import java.util.ArrayList;

/**
 * 플레이어가 입력한 수에 대한 힌트를 제공하는 클래스
 */
public class HintGenerator {
    private static final int INITIAL_VALUE = 0;
    private static final int MINIMUM_INDEX = 0;
    private static final int MAXIMUM_INDEX = 2;
    private static final String ANSWER = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";

    private static int ball;
    private static int strike;

    // 플레이어가 입력한 수에 대한 힌트를 제공하는 함수
    public static String giveHint(ArrayList<Integer> playerNumber) {
        // 프로그램이 정한 임의의 3자리 수
        ArrayList<Integer> programNumber = NumberGenerator.generateProgramNumber();

        // `볼`, `스트라이크`를 초기화한다.
        initBallStrike();
        // 같은 숫자가 있는지 확인한다. (`볼` 개수 확인)
        checkSameNumber(programNumber, playerNumber);
        // 같은 자리에 있는지 확인한다. (`스트라이크` 개수 확인)
        checkSamePosition(programNumber, playerNumber);

        // `정답`, `볼`, `스트라이크`, `낫싱`을 확인한다.
        String result = checkResult();

        return result;
    }

    // `볼`, `스트라이크`를 초기화하는 함수
    public static void initBallStrike() {
        ball = INITIAL_VALUE;
        strike = INITIAL_VALUE;
    }

    // 같은 숫자가 있는지 확인하는 함수 (`볼` 개수 확인)
    public static void checkSameNumber(ArrayList<Integer> programNumber, ArrayList<Integer> playerNumber) {
        for (int i = MINIMUM_INDEX; i <= MAXIMUM_INDEX; i++) {
            if (programNumber.contains(playerNumber.get(i))) {
                ball++;
            }
        }
    }

    // 같은 자리에 있는지 확인하는 함수 (`스트라이크` 개수 확인)
    public static void checkSamePosition(ArrayList<Integer> programNumber, ArrayList<Integer> playerNumber) {
        for (int i = MINIMUM_INDEX; i <= MAXIMUM_INDEX; i++) {
            if (programNumber.get(i) == playerNumber.get(i)) {
                strike++;
                ball--;
            }
        }
    }

    // `정답`, `볼`, `스트라이크`, `낫싱`을 확인하는 함수
    public static String checkResult() {
        if (strike == 3) {
            return strike+ANSWER;
        } else if (ball != 0 && strike == 0) {
            return ball+BALL;
        } else if (ball == 0 && strike != 0) {
            return strike+STRIKE;
        } else if (ball == 0 && strike == 0) {
            return NOTHING;
        } else {
            return ball+BALL+" "+strike+STRIKE;
        }
    }
}
