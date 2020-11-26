package baseball;

import java.util.HashSet;
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
        HashSet<Integer> tempHashSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            int uniqueNumber = RandomUtils.nextInt(1, 9);
            while (tempHashSet.contains(uniqueNumber)) {
                uniqueNumber = RandomUtils.nextInt(1, 9);
            }
            tempHashSet.add(uniqueNumber);
            randomNumberArray[i] = uniqueNumber;
        }
        return randomNumberArray;
    }


    public static boolean diffArray(int[] user, int[] random) {
        String gameMessage = "";
        int[] countResult = new int[2];
        boolean gameResult = false;
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < user.length; i++) {
            for (int j = 0; j < random.length; j++) {
                countResult = counterRound(i, user[i], j, random[j]);
                strikeCount += countResult[0];
                ballCount += countResult[1];
            }
        }
        if (ballCount != 0) {
            gameMessage += ballCount + "볼 ";
        }
        if (strikeCount != 0) {
            gameMessage += strikeCount + "스트라이크";
        }
        if (ballCount <= 0 && strikeCount <= 0) {
            gameMessage = "낫싱";
        }
        if (strikeCount == 3) {
            gameResult = true;
        }
        System.out.println(gameMessage);
        return gameResult;
    }

    public static int[] counterRound(int userRound, int userNumber, int randomRound,
        int randomNumber) {
        int[] countResult = new int[2];
        if (userNumber == randomNumber && userRound == randomRound) {
            countResult[0] += 1;
        }
        if (userNumber == randomNumber) {
            countResult[1] += 1;
        }
        return countResult;
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
