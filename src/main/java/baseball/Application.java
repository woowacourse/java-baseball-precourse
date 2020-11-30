package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        while (true) {
            new BaseballGame().startGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int inputNum = inputUserNumber(scanner);

            if (inputNum == 2) {
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
    private static int inputUserNumber(Scanner scanner) {
        while (true) {
            int inputNum = scanner.nextInt();
            try {
                checkInputNum(inputNum);
            } catch (IllegalArgumentException e) {
                System.out.println("[잘못된 입력]게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
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
    private static void checkInputNum(int inputNum) throws IllegalArgumentException{
        if (!isValidInput(inputNum)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 매개변수 inputNum이 1또는 2인지 확인하는 메서드
     *
     * @param inputNum 사용자가 입력한 값
     * @return 1또는 2 라면 true, 아니라면 false
     */
    private static boolean isOneOrTwo(int inputNum) {
        return inputNum == 1 || inputNum == 2;
    }

    private static boolean isValidInput(int inputNum) {
        return isOneOrTwo(inputNum);
    }
}
