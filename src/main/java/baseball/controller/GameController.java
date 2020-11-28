package baseball.controller;

import baseball.generator.HintGenerator;
import baseball.generator.NumberGenerator;
import utils.InputUtils;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 게임을 컨트롤하는 클래스
 */
public class GameController {
    private static final String PLAYER_NUMBER_INFO = "숫자를 입력해주세요 : ";
    private static final int NUMBER_SIZE = 3;
    private static final int MINIMUM_INDEX = 0;
    private static final int MAXIMUM_INDEX = 2;
    private static final String ANSWER = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_STATUS_INFO = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String RESTART = "1";
    private static final String FINISH = "2";
    private static final String INVALID_INPUT = "`1` 또는 `2`만 입력해주세요.";
    private static final String INITIAL_RESULT = "";

    private static String result = new String();
    private static String scannerNumber = new String();
    private static String playerStatus;

    // 게임을 시작하는 함수
    public static void startGame(Scanner scanner) {
        System.out.println(PLAYER_NUMBER_INFO);
        scanPlayerNumber(scanner);
        System.out.println(result);
    }

    // 플레이어로부터 3자리 수를 입력받는 함수
    public static void scanPlayerNumber(Scanner scanner) {
        scannerNumber = scanner.nextLine();
        validatePlayerNumber(scannerNumber);
    }

    // 플레이어의 입력이 정상적인 입력인지 검증하는 함수
    public static void validatePlayerNumber(String scannerNumber) {
        if (InputUtils.checkValidation(scannerNumber)) {
            // String 형태를 ArrayList<Integer> 형태로 변환한다.
            ArrayList<Integer> playerNumber = convertPlayerNumber(scannerNumber);

            // 플레이어에게 힌트를 제공한다.
            result = HintGenerator.giveHint(playerNumber);
        }
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

    // 게임을 종료하는 함수
    public static boolean finishGame(Scanner scanner) {
        if (result.equals(NUMBER_SIZE + ANSWER)) {
            System.out.println(GAME_STATUS_INFO);
            playerStatus = scanner.nextLine();

            if (playerStatus.equals(RESTART)) {
                result = INITIAL_RESULT;
                NumberGenerator.initProgramNumber();
                return false;
            } else if (playerStatus.equals(FINISH)) {
                return true;
            } else {
                throw new IllegalArgumentException(INVALID_INPUT);
            }
        }

        return false;
    }
}
