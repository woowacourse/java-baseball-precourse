package baseball;

import utils.RandomUtils;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    static boolean[] duplCheck;
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        duplCheck = new boolean[10];
        int[] systemNum = new int[3];
        int systemNumCnt = 0;
        while(systemNumCnt < 3) {
            int tmp = RandomUtils.nextInt(1, 9);
            if(!isDupl(tmp)) {
                systemNum[systemNumCnt] = tmp;
                systemNumCnt++;
            }
        }

        System.out.println(Arrays.toString(systemNum));

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
