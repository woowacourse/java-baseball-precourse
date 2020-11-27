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
        return true;
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
        return 0;
    }

    private static void printStr(int strike, int ball) {

    }

    private static void playGame(Scanner scanner, int[] randomNumber) {

    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
    }
}