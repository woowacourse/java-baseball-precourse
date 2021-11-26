package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    public static int[] target = new int[3];

    // 정답으로 쓰일 임의의 수 3개를 target array에 저장한다.
    public static void makeTarget() {
        for(int i=0; i<3; i++) {
            target[i] = Randoms.pickNumberInRange(1, 9);
        }
    }
}

