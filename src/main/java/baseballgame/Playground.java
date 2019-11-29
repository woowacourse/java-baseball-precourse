package baseballgame;

import java.util.Scanner;

public class Playground {
    private String targetNumber;
    private BaseballGame baseballGame = new BaseballGame();
    private Scanner scanner = new Scanner(System.in);

    public void runBaseballGame() {

        do {
            targetNumber = baseballGame.getRandomNumber();
            System.out.println(targetNumber);
        } while (isInProgress(scanner, targetNumber));

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
            }

        }
    }

    private boolean isCorrectAnswer(String targetNumber, String inputNumber) {
        return targetNumber.equals(inputNumber);
    }

    private String getInputNumber(Scanner scanner) {
        System.out.println("숫자를 입력해주세요");
        String inputNumber = scanner.nextLine();
        return inputNumber;
    }

    private void printInvalidNumberMessage() {
        System.out.println("입력값이 잘못되었습니다.");
        System.out.println("1~9까지의 수 중 서로 다른 세자리 숫자를 입력해주세요.");
    }
    
    private void printCorrectAnswerMessage() {
        System.out.println("정답! 3개의 숫자를 모두 맞혔습니다.");
    }

}
