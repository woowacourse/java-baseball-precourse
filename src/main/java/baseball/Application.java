package baseball;

import java.util.Scanner;
import utils.RandomUtils;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        int userInput;
        int[] inputNumber;
        int[] randomNumber;
        boolean gameResult = false;
        while (!gameResult) {
            System.out.println("숫자를 입력해주세요 : ");
            userInput = scanner.nextInt();
            checkInputNumber(userInput);
            inputNumber = createInputNumber(userInput);
            randomNumber = createRandomNumber();
            gameResult = diffArray(inputNumber, randomNumber);
            if (gameResult) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                gameResult = restartGame();
            }
        }

    }

    public static void checkInputNumber(int numbers) {
        if (numbers < 100 || numbers > 1000) {
            throw new IllegalArgumentException("3자리 수가 아닙니다.");
        }
    }

    public static int[] createInputNumber(int numbers) {
        String temp = Integer.toString(numbers);
        int[] inputNumberArray = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            inputNumberArray[i] = temp.charAt(i) - '0';
        }
        return inputNumberArray;
    }

    public static int[] createRandomNumber() {
        int[] randomNumberArray = new int[3];
        for (int i = 0; i < 3; i++) {
            randomNumberArray[i] = RandomUtils.nextInt(1, 9);
        }
        return randomNumberArray;
    }

    public static boolean diffArray(int[] user, int[] random) {
        boolean gameResult = false;
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < user.length; i++) {
            for (int j = 0; j < random.length; j++) {
                if (user[i] == random[j] && i == j) {
                    strikeCount++;
                }
                if (user[i] == random[j]) {
                    ballCount++;
                }
            }
        }
        if (strikeCount == 3) {
            System.out.println(strikeCount + "스트라이크");
            gameResult = true;
        } else if (strikeCount > 0 && ballCount > 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        } else if (strikeCount > 0 && ballCount <= 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (ballCount > 0 && strikeCount <= 0) {
            System.out.println(ballCount + "볼");
        } else if (ballCount <= 0 && strikeCount <= 0) {
            System.out.println("낫싱");
        }
        return gameResult;
    }

    private static boolean restartGame() {
        Scanner scanner = new Scanner(System.in);
        int userRestartInput;
        boolean restart = true;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        userRestartInput = scanner.nextInt();
        if (userRestartInput <= 1) {
            restart = false;
        }
        return restart;
    }
}
