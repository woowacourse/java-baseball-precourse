package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer extends GameBalls {

    public Computer() {
        super();
        this.sequence = new Ball[NUMBEROFBALLS];
        boolean[] isUsedNumber = new boolean[10];

        int index = 0;
        while (index != NUMBEROFBALLS) {
            int pickNumberInRange = Randoms.pickNumberInRange(1, 9);
            if (isUsedNumber[pickNumberInRange]) {
                continue;
            }

            this.sequence[index] = new Ball(pickNumberInRange);
            isUsedNumber[pickNumberInRange] = true;
            index++;
        }
    }

}
