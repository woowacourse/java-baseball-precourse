/*
 * 클래스 이름 : Computer
 *
 * 버전 정보 : 1.0
 *
 * 날짜 : 2019.12.3
 *
 * 저작권 주의 : https://github.com/takhyeongmin
 */

import domain.ScoreBoard;
import utils.ScoreBoardUtil;

public class Computer {

    private ScoreBoard scoreBoard;

    Computer() {
        this.scoreBoard
                = generateAnswerScoreBoard(new RandomNumberCardGenerator());
    }

    private ScoreBoard generateAnswerScoreBoard(
            RandomNumberCardGenerator randomNumberCardGenerator) {
        return randomNumberCardGenerator.createScoreBoard(new ScoreBoardUtil());
    }

    ScoreBoard getScoreBoard() {
        return scoreBoard;
    }
}
