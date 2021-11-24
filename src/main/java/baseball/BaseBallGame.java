package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallGame {
    private int answerNum;

    public void start() {
        makeAnswerNum();
    }

    private void makeAnswerNum() {
        answerNum = Randoms.pickNumberInRange(111, 999);
    }

}