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
        return new int[0];
    }

    private static boolean getIsRestart(Scanner scanner) {
        return true;
    }

    private static int findStrike(int[] randomNumber, int[] userNumber) {
        return 0;
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