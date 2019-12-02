/**
 * 클래스 이름 : PlayGame.java
 *
 * @version 1.0
 *
 * 날짜 : 2019.12.2 월요일
 *
 * @author Seungwan Park, github.com/toneyparky
 */

import java.util.ArrayList;

/**
 * PlayGame 클래스에서는 게임을 실행하는 로직을 담당한다.
 * NumberGenerator클래스의 numberGenerator를 이용하여 만든 세자리수를 guessingNumberList에 저장한다.
 */

public class PlayGame {
    private static ArrayList<Integer> guessingNumberList = new ArrayList<>();
    private static ArrayList<Integer> userNumberList = new ArrayList<>();
    private static ArrayList<Integer> ballStrikeList = new ArrayList<>();

    /** 게임 실행 로직을 담당하는 playGame메서드 */
    public static void playGame() {

        guessingNumberList = NumberGenerator.numberGenerator();
        // 테스트용.
        for (int i = 0; i < guessingNumberList.size(); i++) {
            System.out.println(guessingNumberList.get(i));
        }
        while (true) {
            userNumberList = IntegerToArrayList.integerToArrayList(NumberGetter.numberGetter());
            // 테스트용.
            for (int i = 0; i < userNumberList.size(); i++) {
                System.out.println(userNumberList.get(i));
            }

            NumberComparer nc = new NumberComparer(guessingNumberList, userNumberList);
            ballStrikeList = nc.numberComparer();
            // 테스트용.
            for (int i = 0; i < ballStrikeList.size(); i++) {
                System.out.println("ballStrikeList: " + i + "  " + ballStrikeList.get(i));
            }

            if (ResultGenerator.resultGenerator(ballStrikeList)) break;
        }
    }

}
