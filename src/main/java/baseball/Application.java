package baseball;

import utils.RandomUtils;
import java.util.Scanner;

public class Application {

    private static int[] getRandomNumber() {
        int count = 0;
        int temp;
        int[] answer = new int[3];
        boolean[] visited = new boolean[10];
        while (count < 3) {
            temp = RandomUtils.nextInt(1, 9);
            if (!visited[temp]) {
                answer[count] = temp;
                visited[temp] = true;
                count++;
            }
        }
        return answer;
    }

    private static int[] getUserNumber(Scanner scanner) {
        System.out.print("숫자를 입력해주세요 : ");
        int[] answer = new int[3];
        try {
            int number = scanner.nextInt();
            if (number < 123 || number > 987) {
                throw new IllegalArgumentException();
            }
            answer[0] = number / 100;
            number %= 100;
            answer[1] = number / 10;
            answer[2] = number % 10;
            if (answer[0] == answer[1] || answer[0] == answer[2] || answer[1] == answer[2]) {
                throw new IllegalArgumentException();
            }
        } catch (Exception exception) {
            throw new IllegalArgumentException();
        }
        return answer;
    }

    private static boolean getIsRestart(Scanner scanner) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            int number = scanner.nextInt();
            if (number == 1) {
                return true;
            } else if (number == 2) {
                return false;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (Exception exception) {
            throw new IllegalArgumentException();
        }
    }

    private static int findStrike(int[] randomNumber, int[] userNumber) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (randomNumber[i] == userNumber[i]) {
                count++;
            }
        }
        return count;
    }

    private static int findBall(int[] randomNumber, int[] userNumber) {
        int count = 0;
        if (randomNumber[0] == userNumber[1] || randomNumber[0] == userNumber[2]) {
            count++;
        }
        if (randomNumber[1] == userNumber[0] || randomNumber[1] == userNumber[2]) {
            count++;
        }
        if (randomNumber[2] == userNumber[0] || randomNumber[2] == userNumber[1]) {
            count++;
        }
        return count;
    }

    private static void printStr(int strike, int ball) {
        String str = "";
        if (strike == 0 && ball == 0) {
            str = "낫싱";
        } else if (strike == 3) {
            str = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        } else {
            if (ball != 0) {
                str += ball + "볼 ";
            }
            if (strike != 0) {
                str += strike + "스트라이크";
            }
        }
        System.out.println(str);
    }

    private static void playGame(Scanner scanner, int[] randomNumber) {
        int strike = 0;
        int ball;
        int[] userNumber;
        while (strike != 3) {
            userNumber = getUserNumber(scanner);
            strike = findStrike(randomNumber, userNumber);
            ball = findBall(randomNumber, userNumber);
            printStr(strike, ball);
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        boolean isGame = true;
        while (isGame) {
            playGame(scanner, getRandomNumber());
            isGame = getIsRestart(scanner);
        }
    }
}