/*
 * 클래스 이름 : RandomNumberCardGenerator
 *
 * 버전 정보 : 1.0
 *
 * 날짜 : 2019.12.3
 *
 * 저작권 주의 : https://github.com/takhyeongmin
 */

import domain.BaseBall;
import domain.NumberCard;
import domain.ScoreBoard;
import utils.ScoreBoardUtil;

import java.util.ArrayList;

public class RandomNumberCardGenerator {

    ScoreBoard createScoreBoard(ScoreBoardUtil scoreBoardUtil) {
        ScoreBoard scoreBoard = new ScoreBoard(createBaseBallArrayList());

        while (scoreBoardUtil.checkValid(scoreBoard) != false) {
            scoreBoard = new ScoreBoard(createBaseBallArrayList());
        }
        return scoreBoard;
    }

    private ArrayList<BaseBall> createBaseBallArrayList() {
        ArrayList<BaseBall> numberCards = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            numberCards.add(i, generateBaseBall());
        }
        return numberCards;
    }

    private BaseBall generateBaseBall() {
        return new BaseBall(createRandomRangeNumberCard());
    }

    private static NumberCard createRandomRangeNumberCard() {
        return new NumberCard(createRandomRangeInteger(1, 9));
    }

    private static Integer createRandomRangeInteger(int lowerBound,
                                                    int upperBound) {
        int randomInt = (int) (Math.random()
                * (upperBound - lowerBound + 1)) + lowerBound;
        return randomInt;
    }

}
