/**
 * PlayGame 클래스에서는 게임을 실행하는 로직을 담당한다.
 * NumberGenerator클래스의 numberGenerator를 이용하여 만든 세자리수를 guessingNumberList에 저장한다.
 */

import java.util.ArrayList;

public class PlayGame {
    private static ArrayList<Integer> guessingNumberList = new ArrayList<>();
    private static ArrayList<Integer> userNumberList = new ArrayList<>();

    public static void playGame() {
        guessingNumberList = NumberGenerator.numberGenerator();
        // 테스트용.
        for (int i = 0; i < guessingNumberList.size(); i++) {
            System.out.println(guessingNumberList.get(i));
        }

        userNumberList = IntegerToArrayList.integerToArrayList(NumberGetter.numberGetter());
        // 테스트용.
        for (int i = 0; i < userNumberList.size(); i++) {
            System.out.println(userNumberList.get(i));
        }

    }

}
