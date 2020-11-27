package baseball.controller;

import baseball.generator.HintGenerator;
import utils.InputUtils;

import java.util.ArrayList;

/**
 * 게임을 컨트롤하는 클래스
 */
public class GameController {
    private static final int NUMBER_SIZE = 3;
    private static final int MINIMUM_INDEX = 0;
    private static final int MAXIMUM_INDEX = 2;
    private static final String ANSWER = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String INFORMATION = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static String result = new String();

    // 플레이어로부터 3자리 수를 입력받는 함수
    public static String scanPlayerNumber(String scannerNumber) {
        // 정상적인 입력인 경우
        if (InputUtils.checkValidation(scannerNumber)) {
            // String 형태를 ArrayList<Integer> 형태로 변환한다.
            ArrayList<Integer> playerNumber = convertPlayerNumber(scannerNumber);

            // 플레이어에게 힌트를 제공한다.
            result = HintGenerator.giveHint(playerNumber);
        }

        return result;
    }

    // String 형태를 ArrayList<Integer> 형태로 변환하는 함수
    public static ArrayList<Integer> convertPlayerNumber(String scannerNumber) {
        ArrayList<Integer> playerNumber = new ArrayList<>(NUMBER_SIZE);

        for (int i = MINIMUM_INDEX; i <= MAXIMUM_INDEX; i++) {
            String scannerSubNumber = scannerNumber.substring(i, i+1);
            playerNumber.add(Integer.parseInt(scannerSubNumber));
        }

        return playerNumber;
    }

    // 프로그램의 3자리 숫자와 플레이어의 3자리 숫자가 같은 경우 게임을 종료하는 함수
    public static boolean continueGame() {
        if (result.equals(NUMBER_SIZE+ANSWER)) {
            System.out.println(INFORMATION);
            return false;
        }
        return true;
    }
}
