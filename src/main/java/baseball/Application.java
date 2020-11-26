package baseball;

import java.util.Arrays;
import java.util.Scanner;

import utils.RandomUtils;

public class Application {

    private static final int BASEBALL_NUMBERS_LENGTH = 3;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    private static int[] generateRandomNumbers() {
        int[] randomNumbers = new int[BASEBALL_NUMBERS_LENGTH];
        int idx = 0;
        while (idx < BASEBALL_NUMBERS_LENGTH) {
            int randomNumber = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
            if (Arrays.stream(randomNumbers).noneMatch(x -> x == randomNumber)) {
                randomNumbers[idx] = randomNumber;
                idx ++;
            }
        }
        return randomNumbers;
    }

    private static int[] parseInputString(String inputString) {
        int[] inputNumbers = new int[BASEBALL_NUMBERS_LENGTH];
        for (int i = 0; i < BASEBALL_NUMBERS_LENGTH; i++) {
            inputNumbers[i] = inputString.charAt(i) - '0';
        }
        return inputNumbers;
    }

    private static boolean isInputAcceptable(String inputString) {

        try {
            Integer.parseInt(inputString);
            if (inputString.length() != BASEBALL_NUMBERS_LENGTH) {
                throw new IllegalArgumentException();
            }
            if (inputString.contains("0")) {
                throw new IllegalArgumentException();
            }
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static int[] countStrikesAndBalls(int[] answer, int[] inputNumbers) {
        int strikes = 0;
        int balls = 0;
        int[] result = new int[2];
        for (int i = 0; i < BASEBALL_NUMBERS_LENGTH; i++) {
            int num = inputNumbers[i];
            if (answer[i] == inputNumbers[i]) {
                strikes ++;
            } else if (Arrays.stream(answer).anyMatch(x -> x == num)) {
                balls ++;
            }
        }
        result[0] = strikes;
        result[1] = balls;

        return result;
    }

    private static boolean isNothing(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            return true;
        }
        return false;
    }

    private static boolean checkResult(int strikes) {
        if (strikes == BASEBALL_NUMBERS_LENGTH) {
            return true;
        }
        return false;
    }

    private static void printResult(int strikes, int balls, boolean nothing) {
        String result = "";
        if (nothing) {
            result = "낫싱";
        } else {
            if (balls > 0) {
                result += balls +"볼 ";
            }
            if (strikes > 0) {
                result += strikes + "스트라이크";
            }
        }
        System.out.println(result);
    }

    public static boolean endGame(Scanner scanner) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int restart = scanner.nextInt();
        try {
            if (restart == 1) {
                return true;
            } else if (restart == 2) {
                return false;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean gameStart(Scanner scanner) {
        // 랜덤 숫자 생성
        int[] answer = generateRandomNumbers();

        String inputString = "";
        boolean isCorrect = false;

        while(!isCorrect) {
            // 1~9로 이루어진 3자리 숫자 입력
            System.out.println("숫자를 입력해주세요 : ");
            inputString = scanner.next();

            // 비정상적인 입력 확인
            if (!isInputAcceptable(inputString)) {
                continue;
            }

            // 스트라이크와 볼의 개수, 낫싱 여부 확인
            int[] inputNumbers = parseInputString(inputString);
            int[] numberOfStrikesAndBalls = countStrikesAndBalls(answer, inputNumbers);
            int strikes = numberOfStrikesAndBalls[0];
            int balls = numberOfStrikesAndBalls[1];
            boolean nothing = isNothing(strikes, balls);

            // 힌트 출력
            printResult(strikes, balls, nothing);

            // 정답 여부 확인
            isCorrect = checkResult(strikes);
        }

       return endGame(scanner);
    }


    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        boolean gameStart = true;

        // start game
        while (gameStart) {
            gameStart = gameStart(scanner);
        }
        // end of game

    }
}
