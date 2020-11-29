package baseball;

import utils.InputValidator;
import utils.RandomGenerator;

import java.util.Arrays;
import java.util.Scanner;

public class Game {

    private static final int BASEBALL_NUMBERS_LENGTH = 3;
    private static final String RESTART_GAME = "1";
    private static final String FINISH_GAME = "2";
    private static Scanner scanner;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    private int[] parseInputString(String inputString) {
        int[] inputNumbers = new int[BASEBALL_NUMBERS_LENGTH];
        for (int i = 0; i < BASEBALL_NUMBERS_LENGTH; i++) {
            inputNumbers[i] = inputString.charAt(i) - '0';
        }

        return inputNumbers;
    }

    private int[] takeInGameInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String inputString = scanner.next();
        InputValidator.inGameNumber(inputString, BASEBALL_NUMBERS_LENGTH);

        return parseInputString(inputString);
    }

    private int countStrike(int[] answer, int[] inputNumbers) {
        int strikes = 0;

        for (int i = 0; i < BASEBALL_NUMBERS_LENGTH; i++) {
            if (answer[i] == inputNumbers[i]) {
                strikes ++;
                continue;
            }
        }

        return strikes;
    }

    private int countBalls(int[] answer, int[] inputNumbers) {
        int balls = 0;

        for (int i = 0; i < BASEBALL_NUMBERS_LENGTH; i++) {
            if (inputNumbers[i] == answer[i]) {
                continue;
            }

            int num = inputNumbers[i];
            if (Arrays.stream(answer).anyMatch(x -> x == num)) {
                balls ++;
            }
        }

        return balls;
    }

    private boolean checkResultBy(int strikes) {
        if (strikes == BASEBALL_NUMBERS_LENGTH) {
            return true;
        }
        return false;
    }

    private void printHint(int strikes, int balls) {
        String result = "";

        if (balls > 0) {
            result += balls +"볼 ";
        }

        if (strikes > 0) {
            result += strikes + "스트라이크";
        }

        if (strikes == 0 && balls == 0) {
            result = "낫싱";
        }

        System.out.println(result);
    }

    public boolean restartGame() {
        System.out.println( BASEBALL_NUMBERS_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 " + RESTART_GAME + ", 종료하려면 " + FINISH_GAME + "를 입력하세요.");

        String restart = scanner.next();
        InputValidator.gameStartOrStop(restart, RESTART_GAME, FINISH_GAME);

        if (restart.equals(RESTART_GAME)) {
            return true;
        }
        return false;
    }

    public void start() {

        boolean gameStart = true;
        while (gameStart) {
            int[] answer = RandomGenerator.generateRandomNumbers(BASEBALL_NUMBERS_LENGTH);

            boolean isCorrect = false;
            while(!isCorrect) {
                int[] inputNumbers = takeInGameInput();

                int strikes = countStrike(answer, inputNumbers);
                int balls = countBalls(answer, inputNumbers);

                printHint(strikes, balls);
                isCorrect = checkResultBy(strikes);
            }
            gameStart = restartGame();
        }
    }

}
