package baseball.controller;

import baseball.generator.HintGenerator;
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

    private static String result = new String();
    private static String scannerNumber = new String();

    // 플레이어로부터 3자리 수를 입력받는 함수
    public static void scanPlayerNumber(Scanner scanner) {
        System.out.print(PLAYER_NUMBER_INFO);
        scannerNumber = scanner.nextLine();

        // 정상적인 입력인 경우
        if (InputUtils.checkValidation(scannerNumber)) {
            // String 형태를 ArrayList<Integer> 형태로 변환한다.
            ArrayList<Integer> playerNumber = convertPlayerNumber(scannerNumber);

            // 플레이어에게 힌트를 제공한다.
            result = HintGenerator.giveHint(playerNumber);
            System.out.println(result);
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
}
