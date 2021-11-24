package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Controller {


    private Integer createRandomNumber() {
        return Randoms.pickNumberInRange(100, 1000);
    }
}
