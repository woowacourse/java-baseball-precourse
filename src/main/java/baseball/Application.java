package baseball;

import utils.RandomUtils;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    static boolean[] duplCheck;
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        // 프로그램이 1에서 9까지 서로 다른 임의의 수 3개를 정한다
        duplCheck = new boolean[10];
        int[] systemNum = new int[3];
        int numCnt = 0;
        while(numCnt < 3) {
            int tmp = RandomUtils.nextInt(1, 9);
            if(!isDupl(tmp)) {
                systemNum[numCnt] = tmp;
                numCnt++;
            }
        }
        System.out.println(Arrays.toString(systemNum));

        // 플레이어가 3자리 수를 입력한다.
        System.out.print("숫자를 입력해주세요 : ");
        char[] charUserNum = scanner.next().toCharArray();

        int[] userNum = new int[3];
        for (int i = 0; i < 3; i++) {
            userNum[i] = charUserNum[i] - '0';
        }

        System.out.println(Arrays.toString(userNum));

        // 스트라이크 체크하기
        int strikeCnt = checkStrike(userNum, systemNum);

        // 정답 체크하기
        if(strikeCnt == 3) {
            System.out.println(strikeCnt + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

        // 볼 체크하기
        int ballCnt = checkBall(userNum, systemNum);
        if(ballCnt == 0 && strikeCnt == 0) {
            System.out.println("낫싱");
        } else if(ballCnt == 0){
            System.out.println(strikeCnt + "스트라이크");
        } else if(strikeCnt == 0) {
            System.out.println(ballCnt + "볼");
        } else {
            System.out.println(ballCnt + "볼" + " " + strikeCnt + "스트라이크");
        }

    }

    private static int checkBall(int[] userNum, int[] systemNum) {
        int ballCnt = 0;
        for (int i = 0; i < 3; i++) {
            int tmp = userNum[i];
            if(tmp != systemNum[i] && duplCheck[tmp]) {
                ballCnt++;
            }
        }
        return ballCnt;
    }

    private static int checkStrike(int[] userNum, int[] systemNum) {
        int strikeCnt = 0;
        for (int i = 0; i < 3; i++) {
            if(userNum[i] == systemNum[i]) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    private static boolean isDupl(int checkNum) {
        if(duplCheck[checkNum]) {
            return true;
        } else {
            duplCheck[checkNum] = true;
            return false;
        }
    }
}
