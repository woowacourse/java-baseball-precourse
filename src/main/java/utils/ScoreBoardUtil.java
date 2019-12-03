/*
 * 클래스 이름 : ScoreBoardUtil
 *
 * 버전 정보 : 1.0
 *
 * 날짜 : 2019.12.3
 *
 * 저작권 주의 : https://github.com/takhyeongmin
 */

package utils;

import domain.BaseBall;
import domain.NumberCard;
import domain.ScoreBoard;

import java.util.ArrayList;

public class ScoreBoardUtil {

    public boolean checkValid(ScoreBoard scoreBoard) {
        if ((checkDuplicte(scoreBoard) == false)
                && (checkScoreLength(scoreBoard) == false)) {
            return false;
        } else {
            return true;
        }
    }

    private Boolean checkDuplicte(ScoreBoard scoreBoard) {
        ArrayList<BaseBall> tmpScoreBoard = scoreBoard.getScoreBoard();
        boolean[] duplicateCheckArr = new boolean[10];
        NumberCard numberCard;

        for (int i = 0; i < tmpScoreBoard.size(); i++) {
            numberCard = tmpScoreBoard.get(i).getNumberCard();

            if (duplicateCheckArr[numberCard.of()] == true) {
                return true;
            }
            if (duplicateCheckArr[numberCard.of()] == false) {
                duplicateCheckArr[numberCard.of()] = true;
            }
        }
        return false;
    }

    private Boolean checkScoreLength(ScoreBoard scoreBoard) {
        if (scoreBoard.getScoreBoard().size() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return false;
    }
}
