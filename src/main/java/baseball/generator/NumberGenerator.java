package baseball.generator;

import utils.RandomUtils;

import java.util.ArrayList;

/**
 * 프로그램에서 1에서 9까지 서로 다른 임의의 수 3개를 정하는 클래스
 */
public class NumberGenerator {
    private static final int FLAG_SIZE = 10;
    private static final int RANDOM_SIZE = 3;
    private static final int MINIMUM_INDEX = 0;
    private static final int MAXIMUM_INDEX = 9;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int FALSE = 0;
    private static final int TRUE = 1;

    private static int[] flag = new int[FLAG_SIZE];
    private static ArrayList<Integer> programNumber = new ArrayList<>(RANDOM_SIZE);

    // flag 변수를 초기화 시키는 함수
    public static int[] initFlag() {
        for (int i = MINIMUM_INDEX; i <= MAXIMUM_INDEX; i++) {
            flag[i] = FALSE;
        }

        return flag;
    }

    // 프로그램에서 1에서 9까지 서로 다른 임의의 수 3개를 정하는 함수
    public static ArrayList<Integer> generateProgramNumber() {
        // flag 초기화
        flag = initFlag();

        // 임의의 수 3개를 정한다.
        while (programNumber.size() != RANDOM_SIZE) {
            // 1에서 9까지 범위 내에서 임의의 수를 구한다.
            int random = RandomUtils.nextInt(MINIMUM_NUMBER, MAXIMUM_NUMBER);
            int index = random - 1;

            // 아직 구한 숫자가 사용되지 않은 경우 해당 임의의 수를 사용한다.
            if (flag[index] == FALSE) {
                programNumber.add(random);
                flag[index] = TRUE;
            } else {            // 이미 구한 숫자가 사용된 경우 새로운 임의의 수를 구한다.
                continue;
            }
        }

        return programNumber;
    }
}
