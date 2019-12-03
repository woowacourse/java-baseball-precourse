/*
 * 클래스 이름 : BaseBallUtil
 *
 * 버전 정보 : 1.0
 *
 * 날짜 : 2019.12.3
 *
 * 저작권 주의 : https://github.com/takhyeongmin
 */

package utils;

import domain.BaseBall;
import domain.ScoreBoard;

import java.util.ArrayList;

public class BaseBallUtil {
    public Integer countStrike(ScoreBoard answerScoreBoard,
                               ScoreBoard userInputScoreBoard) {
        int strike = 0;
        ArrayList<BaseBall> answer = answerScoreBoard.getScoreBoard();
        ArrayList<BaseBall> userInput = userInputScoreBoard.getScoreBoard();

        for (int i = 0; i < userInput.size(); i++) {
            Integer answerNumberCard = answer.get(i).getNumberCard().of();
            Integer userNumberCard = userInput.get(i).getNumberCard().of();
            if (answerNumberCard.equals(userNumberCard)) {
                strike++;
            }
        }
        return strike;
    }

    public Integer countBall(ScoreBoard answerScoreBoard,
                             ScoreBoard userInputScoreBoard) {
        int ball = 0;
        ArrayList<BaseBall> answer = answerScoreBoard.getScoreBoard();
        ArrayList<BaseBall> userInput = userInputScoreBoard.getScoreBoard();

        for (int i = 0; i < userInput.size(); i++) {
            ball += countBallOfIndex(i, answer, userInput);
        }
        return ball;
    }

    private Integer countBallOfIndex(Integer ballIndex,
                                     ArrayList<BaseBall> answer,
                                     ArrayList<BaseBall> userInput) {
        int ball = 0;
        Integer answerNumberCard = answer.get(ballIndex).getNumberCard().of();
        Integer userNumberCard;

        for (int i = 0; i < userInput.size(); i++) {
            if (ballIndex.equals(i)) {
                continue;
            }

            userNumberCard = userInput.get(i).getNumberCard().of();

            if (answerNumberCard.equals(userNumberCard)) {
                ball++;
            }
        }
        return ball;
    }

    public boolean isThreeStrike(Integer strike) {
        return strike.equals(3);
    }
}
