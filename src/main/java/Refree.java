/*
 * 클래스 이름 : Refree
 *
 * 버전 정보 : 1.0
 *
 * 날짜 : 2019.12.3
 *
 * 저작권 주의 : https://github.com/takhyeongmin
 */

import domain.ScoreBoard;
import utils.BaseBallUtil;
import utils.OutputUtil;

public class Refree {

    Boolean startCountScore(ScoreBoard answer, ScoreBoard userInput) {
        BaseBallUtil baseBallUtil = new BaseBallUtil();
        int strike = baseBallUtil.countStrike(answer, userInput);
        int ball = baseBallUtil.countBall(answer, userInput);
        OutputUtil outputUtil = new OutputUtil();

        outputUtil.printScore(strike, ball);
        return baseBallUtil.isThreeStrike(strike);
    }
}
