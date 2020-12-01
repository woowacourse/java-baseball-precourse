package baseball;

import utils.RandomUtils;

public class ThreeNumGenerator {
    private static int NUMBER_SIZE = 3;
    private static int[] comNum = new int[NUMBER_SIZE];

    public static int[] generate() {
        /* 길이 3의 배열 생성 후 각 인덱스에 임의의 수 할당 */
        for (int i = 0; i < comNum.length; i++) {
            comNum[i] = RandomUtils.nextInt(1, 9);
        }

        /* 각 인덱스에 겹치는 수가 있다면 새로운 값을 할당해 겹치는 수가 없게 만듦 */
        while (comNum[0] == comNum[1] || comNum[0] == comNum[2] || comNum[1] == comNum[2]) {
            comNum[1] = RandomUtils.nextInt(1, 9);
            comNum[2] = RandomUtils.nextInt(1, 9);
        }

        return comNum;
    }
}
