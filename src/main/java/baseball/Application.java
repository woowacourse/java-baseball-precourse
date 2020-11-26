package baseball;

import utils.RandomUtils;

import java.util.Scanner;


public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        final int NUMBER_LENGTH = 3;
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 9;
        int[] computerPickedNumbers = new int[NUMBER_LENGTH];
        int[] playerPickedNumbers = new int[NUMBER_LENGTH];

        // 프로그램이 임의의 수 3개를 정하도록 하기
        for(int i=0; i<NUMBER_LENGTH; i++) {
            computerPickedNumbers[i] = RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);
        }

        System.out.print("숫자를 입력해주세요 : ");
        // 플레이어가 3자리 수 입력하기
        for(int i = 0; i < NUMBER_LENGTH; i++) {
            // 비정상적 입력에 대해서는 IllegalArgumentException을 발생시킨다.
            playerPickedNumbers[i] = scanner.nextInt();
        }

        // 비교하기 -> 정답 맞출 경우 종료
        for(int i = 0; i < NUMBER_LENGTH; i++) {
            if(computerPickedNumbers[i] == playerPickedNumbers[i]){
                System.out.println("정답!");
            } else {
                System.out.println("오답!");
            }
        }

        // 결과 출력

        // 다시 할지 묻기
        // 비정상적 입력에 대해서는 IllegalArgumentException을 발생시킨다.
    }
}
