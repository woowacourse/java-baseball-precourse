/*
 * 클래스 이름 : ConvertUtil
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

public class ConvertUtil {

    public ScoreBoard convertScoreBoard(Integer number) {
        String temp = Integer.toString(number);
        ArrayList<BaseBall> baseBalls = new ArrayList<>();

        for (int i = 0; i < temp.length(); i++) {
            int digitNumber = temp.charAt(i) - '0';
            baseBalls.add(convertBaseBall(digitNumber));
        }
        return new ScoreBoard(baseBalls);
    }

    private BaseBall convertBaseBall(Integer digitNumber) {
        NumberCard numberCard = new NumberCard(digitNumber);
        return new BaseBall(numberCard);
    }
}
