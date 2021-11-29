package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private final int num;
    private final int RAN_MIN = 100;
    private final int RAN_MAX = 999;

    public Computer() {
        num = Randoms.pickNumberInRange(RAN_MIN, RAN_MAX);
    }

    public int getNumber() {
        return num;
    }
}
