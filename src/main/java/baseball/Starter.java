package baseball;

import java.util.Scanner;

/**
 * 게임을 시작하는 함수를 호출하고 게임 종료 후 게임을 새로 시작할지 종료할지를 입력받는 클래스
 *
 * @version 1.0 2020-11-29
 */
public class Starter {

    private static final String RESTART = "1";
    private static final String EXIT = "2";

    public void startGame(Scanner scanner) {
        while (true) {
            new BaseballGame().playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String inputNum = getUserInputNumber(scanner);

            if (inputNum.equals(EXIT)) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }

    /**
     * 사용자에게 1또는 2를 입력받는 메서드,
     * 1또는 2 이외의 값을 입력 받으면  IllegalArgumentException 발생
     *
     * @param scanner 입력 받기위한 Scanner 타입의 매개변수
     * @return 1또는 2의 값을 반환합니다.
     */
    private String getUserInputNumber(Scanner scanner) {
        while (true) {
            String inputNum = scanner.nextLine();
            try {
                checkInputNum(inputNum);
            } catch (IllegalArgumentException e) {
                System.out.println("[잘못된 입력]게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                continue;
            }
            return inputNum;
        }
    }

    /**
     * 사용자가 입력한 값이 1 또는 2인지 확인하는 메서드.
     *
     * @param inputNum 사용자가 입력한 값을 매개변수로 받습니다.
     * @throws IllegalArgumentException 1또는 2 이외의 값을 입력받으면 해당 예외를 던집니다.
     */
    private void checkInputNum(String inputNum) throws IllegalArgumentException{
        if (!isValidInput(inputNum)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 매개변수 inputNum 이 RESTART 또는 EXIT인지 확인하는 메서드
     *
     * @param inputNum 사용자가 입력한 값
     * @return RESTART 또는 EXIT 라면 true, 아니라면 false
     */
    private boolean isRestartOrExit(String inputNum) {
        return inputNum.equals(RESTART) || inputNum.equals(EXIT);
    }

    private boolean isValidInput(String inputNum) {
        return isRestartOrExit(inputNum);
    }
}
