/*
 * 클래스 이름 : ScoreBoard
 *
 * 버전 정보 : 1.0
 *
 * 날짜 : 2019.12.3
 *
 * 저작권 주의 : https://github.com/takhyeongmin
 */

package domain;

import java.util.ArrayList;

public class ScoreBoard {

    private ArrayList<BaseBall> scoreBoard;

    public ScoreBoard(ArrayList<BaseBall> scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    public ArrayList<BaseBall> getScoreBoard() {
        return scoreBoard;
    }

}
