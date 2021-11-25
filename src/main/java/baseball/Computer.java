package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    public static int[] target = new int[3];

    // 정답으로 쓰일 임의의 수 3개를 target array에 저장한다.
    public static void makeTarget() {
        target[0] = Randoms.pickNumberInRange(1, 9);
        target[1] = Randoms.pickNumberInRange(1, 9);
        target[2] = Randoms.pickNumberInRange(1, 9);
    }
}

