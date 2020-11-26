package baseball;

import utils.RandomUtils;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        int[] computerNumber = generateRandomNumber();
    }

    // 컴퓨터의 랜덤 숫자 생성 기능
    public static int[] generateRandomNumber() {
        int[] computerNumber = new int[3];

        while (true) {

            // 숫자 배열화 기능
            for (int i=0; i<computerNumber.length; i++) {
                computerNumber[i] = RandomUtils.nextInt(1, 9);
            }

            // 서로 다른 숫자인지 체크
            if (checkAllDifferent(computerNumber)) {
                break;
            }
        }

        return computerNumber;
    }

    // 서로 다른 숫자인지 체크하는 기능
    public static boolean checkAllDifferent(int[] number) {
        if (number[0] == number[1]) {
            return false;
        }

        if (number[1] == number[2]) {
            return false;
        }

        if (number[2] == number[0]) {
            return false;
        }

        return true;
    }
}
