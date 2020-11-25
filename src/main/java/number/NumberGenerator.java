package number;

import utils.RandomUtils;

import java.util.ArrayList;

public class NumberGenerator {
    private static int[] flag = new int[10];
    private static ArrayList<Integer> programNumber = new ArrayList<>(3);

    // flag 변수를 초기화 시키는 함수
    public static int[] initFlag() {
        for(int i = 0; i < 10; i++) {
            flag[i] = 0;
        }

        return flag;
    }

    // 프로그램에서 1에서 9까지 서로 다른 임의의 수 3개를 정하는 함수
    public static ArrayList<Integer> generateProgramNumber() {
        // flag 초기화
        flag = initFlag();

        // 임의의 수 3개를 정한다.
        while(programNumber.size() != 3) {
            // 1에서 9까지 범위 내에서 임의의 수를 구한다.
            int random = RandomUtils.nextInt(1, 9);
            int index = random - 1;

            // 아직 구한 숫자가 사용되지 않은 경우 해당 임의의 수를 사용한다.
            if(flag[index] == 0) {
                programNumber.add(random);
                flag[index] = 1;
            }
            // 이미 구한 숫자가 사용된 경우 새로운 임의의 수를 구한다.
            else {
                continue;
            }
        }

        return programNumber;
    }
}
