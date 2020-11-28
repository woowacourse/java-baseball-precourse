package baseball.generator;

import baseball.type.BoundaryType;
import baseball.type.SizeType;
import baseball.type.ValueType;
import utils.RandomUtils;

import java.util.ArrayList;

/**
 * 프로그램에서 1에서 9까지 서로 다른 임의의 수 3개를 정하는 클래스
 */
public class NumberGenerator {
    private static int[] flag = new int[SizeType.FLAG_SIZE.getSize()];
    private static ArrayList<Integer> programNumber = new ArrayList<>(SizeType.NUMBER_SIZE.getSize());

    // flag 변수를 초기화 시키는 함수
    public static int[] initFlag() {
        for (int i = BoundaryType.MINIMUM_FLAG.getBoundary(); i <= BoundaryType.MAXIMUM_FLAG.getBoundary(); i++) {
            flag[i] = ValueType.FALSE.getValue();
        }

        return flag;
    }

    // 프로그램에서 1에서 9까지 서로 다른 임의의 수 3개를 정하는 함수
    public static ArrayList<Integer> generateProgramNumber() {
        // flag 초기화
        flag = initFlag();

        // 임의의 수 3개를 정한다.
        while (programNumber.size() != SizeType.NUMBER_SIZE.getSize()) {
            // 1에서 9까지 범위 내에서 임의의 수를 구한다.
            int random = RandomUtils.nextInt(BoundaryType.MINIMUM_NUMBER.getBoundary(), BoundaryType.MAXIMUM_NUMBER.getBoundary());
            int index = random - 1;

            // 아직 구한 숫자가 사용되지 않은 경우 해당 임의의 수를 사용한다.
            if (flag[index] == ValueType.FALSE.getValue()) {
                programNumber.add(random);
                flag[index] = ValueType.TRUE.getValue();
            } else {            // 이미 구한 숫자가 사용된 경우 새로운 임의의 수를 구한다.
                continue;
            }
        }

        return programNumber;
    }

    // 프로그램에서 정한 임의의 수를 초기화하는 함수
    public static void initProgramNumber() {
        programNumber.clear();
    }
}
