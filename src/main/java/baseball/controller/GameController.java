package baseball.controller;

import baseball.type.*;
import baseball.generator.HintGenerator;
import baseball.generator.NumberGenerator;
import utils.InputUtils;

import java.util.ArrayList;
import java.util.Scanner;

/** 게임을 컨트롤하는 클래스 */
public class GameController {
    private static String result = new String();
    private static String scannerNumber = new String();
    private static String playerStatus;
    private static boolean finishStatus = false;

    /**
     * 게임을 컨트롤하는 함수
     *
     * @param scanner
     */
    public static void controlGame(Scanner scanner) {
        while (true) {
            startGame(scanner);

            if (finishGame(scanner)) {
                break;
            }
        }
    }

    /**
     * 게임을 시작하는 함수
     *
     * @param scanner
     */
    public static void startGame(Scanner scanner) {
        System.out.print(TextType.START.getText());
        scanPlayerNumber(scanner);
        System.out.println(result);
    }

    /**
     * 플레이어로부터 3자리 수를 입력받는 함수
     *
     * @param scanner
     */
    public static void scanPlayerNumber(Scanner scanner) {
        scannerNumber = scanner.nextLine();
        validatePlayerNumber(scannerNumber);
    }

    /**
     * 플레이어의 입력이 정상적인 입력인지 검증하는 함수
     *
     * @param scannerNumber
     */
    public static void validatePlayerNumber(String scannerNumber) {
        if (InputUtils.checkValidation(scannerNumber)) {
            ArrayList<Integer> playerNumber = convertPlayerNumber(scannerNumber);
            giveHint(playerNumber);
        }
    }

    /**
     * 플레이어에게 힌트를 제공하는 함수
     *
     * @param playerNumber
     */
    public static void giveHint(ArrayList<Integer> playerNumber) {
        HintGenerator hintGenerator = new HintGenerator();
        result = hintGenerator.generateHint(playerNumber);
    }

    /**
     * String 형태를 ArrayList<Integer> 형태로 반환하는 함수
     *
     * @param scannerNumber
     * @return playerNumber
     */
    public static ArrayList<Integer> convertPlayerNumber(String scannerNumber) {
        ArrayList<Integer> playerNumber = new ArrayList<>(SizeType.NUMBER_SIZE.getSize());

        for (int i = BoundaryType.MINIMUM_INDEX.getBoundary();
             i <= BoundaryType.MAXIMUM_INDEX.getBoundary(); i++) {
            String scannerSubNumber = scannerNumber.substring(i, i+1);
            playerNumber.add(Integer.parseInt(scannerSubNumber));
        }

        return playerNumber;
    }

    /**
     * 게임을 종료하는 함수
     *
     * @param scanner
     * @return true or false
     */
    public static boolean finishGame(Scanner scanner) {
        if (result.equals(ValueType.ANSWER_VALUE.getValue() + HintType.STRIKE.getHint())) {
            System.out.println(ValueType.ANSWER_VALUE.getValue() + TextType.ANSWER.getText());
            System.out.println(TextType.RESTART_OR_FINISH.getText());
            playerStatus = scanner.nextLine();
            checkStatus(playerStatus);
        }

        return finishStatus;
    }

    /**
     * 게임을 재시작하는지 완전히 종료하는지 상태를 확인하는 함수
     *
     * @param playerStatus
     */
    public static void checkStatus(String playerStatus) {
        if (playerStatus.equals(StatusType.RESTART.getStatus())) {
            NumberGenerator numberGenerator = new NumberGenerator();
            numberGenerator.initProgramNumber();
            result = StatusType.INITIAL_RESULT.getStatus();
            finishStatus = false;
        } else if (playerStatus.equals(StatusType.FINISH.getStatus())) {
            finishStatus = true;
        } else {
            throw new IllegalArgumentException(TextType.INVALID_INPUT.getText());
        }
    }
}
