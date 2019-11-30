package baseballgame;

import java.util.Scanner;

public class Playground {
    private String targetNumber;
    private BaseballGame baseballGame = new BaseballGame();
    private Scanner scanner = new Scanner(System.in);

    public void runBaseballGame() {

        do {
            targetNumber = baseballGame.getRandomNumber();
            System.out.println(targetNumber); // 디버깅을 위한 출력
        } while (isInProgress(scanner, targetNumber));

        printGameOverMessage();

    }

    private boolean isInProgress(Scanner scanner, String targetNumber) {

        while (true) {
            String inputNumber = getInputNumber(scanner);

            if (!baseballGame.isValidNumber(inputNumber)) {
                printInvalidNumberMessage();
                continue;
            }

            baseballGame.getScore(targetNumber, inputNumber);

            if (isCorrectAnswer(targetNumber, inputNumber)) {
                printCorrectAnswerMessage();
                return continueGameOrNot();
            }

        }
    }

    private boolean isCorrectAnswer(String targetNumber, String inputNumber) {
        return targetNumber.equals(inputNumber);
    }

    private boolean continueGameOrNot() {
        if (isGameOver(scanner)) {
            return false;
        }
        return true;
    }

    private boolean isGameOver(Scanner scanner) {
        final String STOP = "2";
        final String CONTINUE = "1";
        String inputNumber;

        while (true) {
            printContinueGameOrNotMessage();
            inputNumber = scanner.nextLine();

            if (!inputNumber.equals(CONTINUE) && !inputNumber.equals(STOP)) {
                printValidTypeOfNumber();
                continue;

            } else {
                return inputNumber.equals(STOP);
            }

        }
    }

    private String getInputNumber(Scanner scanner) {
        String inputNumber;
        System.out.println("숫자를 입력해주세요");
        inputNumber = scanner.nextLine();
        return inputNumber;
    }

    private void printInvalidNumberMessage() {
        System.out.println("입력값이 잘못되었습니다.");
        System.out.println("1~9까지의 수 중 서로 다른 세자리 숫자를 입력해주세요.");
    }

    private void printCorrectAnswerMessage() {
        System.out.println("정답! 3개의 숫자를 모두 맞혔습니다.");
    }

    private void printValidTypeOfNumber() {
        System.out.println("1 또는 2만 입력 가능합니다.");
    }

    private void printContinueGameOrNotMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    }

    private void printGameOverMessage() {
        System.out.println("게임이 종료되었습니다.");
    }

}
