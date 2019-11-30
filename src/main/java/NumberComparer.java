/**
 * NumberComparer 클래스에서는 맞춰야할 숫자와 플레이어의 숫자를 비교하여 볼, 스트라이크 판정을 내린다.
 *
 * compareBall: 두 list에 겹치는 수의 개수를 카운트한다. 그리고 ballStrikeList에 insert한다.
 * compareStrike: 두 list의 같은 index에 있는 동일한 수를 카운트한다. 그리고 ballStrikeList에 insert한다.
 * generateFinalCount: ball에서 strike를 빼고 이를 ballStrikeList에 insert한다.
 */

import java.util.ArrayList;

public class NumberComparer {
    private static final int NUMBER_LENGTH = 3;

    private static ArrayList<Integer> guessingNumberList = new ArrayList<>();
    private static ArrayList<Integer> userNumberList = new ArrayList<>();
    private static ArrayList<Integer> ballStrikeList = new ArrayList<>();

    public NumberComparer(ArrayList<Integer> guessingNumberList, ArrayList<Integer> userNumberList) {
        this.guessingNumberList = guessingNumberList;
        this.userNumberList = userNumberList;
    }

    public static ArrayList<Integer> numberComparer() {
        ballStrikeList.clear();
        ballStrikeList.add(compareBall());
        ballStrikeList.add(compareStrike());
        generateFinalCount();
        return ballStrikeList;
    }

    public static int compareBall() {
        int counter = 0;
        for (int eachUserNumber : userNumberList) {
            if (guessingNumberList.contains(eachUserNumber)) {
                counter++;
            }
        }

        return counter;
    }

    public static int compareStrike() {
        int counter = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (guessingNumberList.get(i) == userNumberList.get(i)) {
                counter++;
            }
        }

        return counter;
    }

    public static void generateFinalCount() {
        ballStrikeList.add(ballStrikeList.get(0) - ballStrikeList.get(1));
    }

}
