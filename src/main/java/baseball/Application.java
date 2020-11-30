package baseball;

import utils.RandomUtils;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int[] answerList = generateNumber();
        displayInputMessage();
        scanner.close();
    }

    private static int[] generateNumber() {
        /* 1~9의 서로 다른 수로 이루어진 3자리 난수 생성*/
        int[] answer = new int[3];
        while(answer[0] == answer[1] || answer[0] == answer[2] || answer[1] == answer[2]) {
        /* 중복된 숫자가 있을 경우 다시 생성*/
            answer[0] = RandomUtils.nextInt(1,9);
            answer[1] = RandomUtils.nextInt(1,9);
            answer[2] = RandomUtils.nextInt(1,9);
        }
        return answer;
    }

    private static void displayInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }
}