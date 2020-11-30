package baseball;

import java.util.ArrayList;

public class NumberCompare {
    /*
    * randomNumber와 userNumber를 비교하는 클래스
    * */

    private static final int NUMBER_LENGTH = 3;
    private static ArrayList<Integer> randomNumberList = new ArrayList<>();
    private static ArrayList<Integer> userNumberList = new ArrayList<>();
    private static final ArrayList<Integer> ballStrikeCountList = new ArrayList<>();

    public NumberCompare(ArrayList<Integer> randomNumberList, ArrayList<Integer> userNumberList) {
        this.randomNumberList = randomNumberList;
        this.userNumberList = userNumberList;
    }

    /*
    * ball, strike 갯수를 리스트로 리턴하는 메서드
    * */
    public static ArrayList<Integer> numberCompare() {
        ballStrikeCountList.clear();
        ballStrikeCountList.add(getFinalBallCount());
        ballStrikeCountList.add(compareStrikeCount());

        return ballStrikeCountList;
    }

    /*
     * ball 갯수를 세는 메서드
     * */
    public static int compareBallCount() {
        int cnt = 0;

        for (int singleUserNumber : userNumberList) {
            if (randomNumberList.contains(singleUserNumber)) {
                cnt++;
            }
        }
        return cnt;
    }

    /*
     * strike 갯수를 세는 메서드
     * */
    public static int compareStrikeCount() {
        int count = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (randomNumberList.get(i) == userNumberList.get(i)) {
                count++;
            }
        }
        return count;
    }

    /*
     * 최종적인 ball 갯수를 세는 메서드(strike와 겹치면 ball로 정의하지 않음)
     * */
    public static int getFinalBallCount() {
        int count;
        count = compareBallCount() - compareStrikeCount();
        return count;
    }
}