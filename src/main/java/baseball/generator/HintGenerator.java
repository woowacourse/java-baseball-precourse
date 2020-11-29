package baseball.generator;

import baseball.type.BoundaryType;
import baseball.type.HintType;
import baseball.type.ValueType;

import java.util.ArrayList;

/** 플레이어가 입력한 수에 대한 힌트를 생성하는 클래스 */
public class HintGenerator {
    private static ArrayList<Integer> programNumber = new ArrayList<>();
    private static int ball;
    private static int strike;
    private static String result;

    /** 프로그램에서 정한 임의의 수를 가져오는 함수 */
    public static void getProgramNumber() {
        NumberGenerator numberGenerator = new NumberGenerator();
        programNumber = numberGenerator.generateProgramNumber();
    }

    /**
     * 플레이어가 입력한 수에 대한 힌트를 생성하는 함수
     *
     * @param playerNumber
     * @return result
     */
    public static String generateHint(ArrayList<Integer> playerNumber) {
        getProgramNumber();
        initBallStrike();
        checkSameNumber(programNumber, playerNumber);
        checkSamePosition(programNumber, playerNumber);
        checkResult();

        return result;
    }

    /** `볼`, `스트라이크`를 초기화하는 함수 */
    public static void initBallStrike() {
        ball = ValueType.INITIAL_VALUE.getValue();
        strike = ValueType.INITIAL_VALUE.getValue();
    }

    /**
     * 같은 숫자가 있는지 확인하는 함수
     * 같은 숫자가 있다면 `볼` 개수를 카운트한다.
     *
     * @param programNumber
     * @param playerNumber
     */
    public static void checkSameNumber(ArrayList<Integer> programNumber,
                                       ArrayList<Integer> playerNumber) {
        for (int i = BoundaryType.MINIMUM_INDEX.getBoundary();
             i <= BoundaryType.MAXIMUM_INDEX.getBoundary(); i++) {
            if (programNumber.contains(playerNumber.get(i))) {
                ball++;
            }
        }
    }

    /**
     * 같은 자리에 있는지 확인하는 함수
     * 같은 자리에 있다면 `스트라이크` 개수를 카운트한다.
     *
     * @param programNumber
     * @param playerNumber
     */
    public static void checkSamePosition(ArrayList<Integer> programNumber,
                                         ArrayList<Integer> playerNumber) {
        for (int i = BoundaryType.MINIMUM_INDEX.getBoundary();
             i <= BoundaryType.MAXIMUM_INDEX.getBoundary(); i++) {
            if (programNumber.get(i) == playerNumber.get(i)) {
                strike++;
                ball--;
            }
        }
    }

    /**
     * `정답`, `볼`, `스트라이크`, `낫싱`을 확인하는 함수
     *
     * @return result
     */
    public static String checkResult() {
        if (ball != ValueType.INITIAL_VALUE.getValue() &&
                strike == ValueType.INITIAL_VALUE.getValue()) {
            result = ball + HintType.BALL.getHint();
        } else if (ball == ValueType.INITIAL_VALUE.getValue() &&
                strike != ValueType.INITIAL_VALUE.getValue()) {
            result = strike + HintType.STRIKE.getHint();
        } else if (ball == ValueType.INITIAL_VALUE.getValue() &&
                strike == ValueType.INITIAL_VALUE.getValue()) {
            result = HintType.NOTHING.getHint();
        } else {
            result = ball + HintType.BALL.getHint() + " " + strike + HintType.STRIKE.getHint();
        }

        return result;
    }
}
