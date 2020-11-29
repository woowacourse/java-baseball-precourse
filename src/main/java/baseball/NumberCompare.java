package baseball;

import java.util.ArrayList;

public class NumberCompare {

    private static final int NUMBER_LENGTH = 3;
    private static ArrayList<Integer> randomNumberList;
    private static ArrayList<Integer> userNumberList;
    private static final ArrayList<Integer> ballStrikeCountList = new ArrayList<>();

    public NumberCompare(ArrayList<Integer> randomNumberList, ArrayList<Integer> userNumberList) {
        this.randomNumberList = randomNumberList;
        this.userNumberList = userNumberList;
    }

    public static ArrayList<Integer> numberCompare(ArrayList<Integer> randomNumberList, ArrayList<Integer> userNumberList) {
        ballStrikeCountList.clear();
        ballStrikeCountList.add(getFinalBallCount(randomNumberList, userNumberList));
        ballStrikeCountList.add(compareStrikeCount(randomNumberList, userNumberList));

        return ballStrikeCountList;
    }

    public static int compareBallCount(ArrayList<Integer> randomNumberList, ArrayList<Integer> userNumberList) {
        int cnt = 0;
        System.out.println(randomNumberList);
        System.out.println(userNumberList);

        for (int singleUserNumber : userNumberList) {
            if (randomNumberList.contains(singleUserNumber)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static int compareStrikeCount(ArrayList<Integer> randomNumberList, ArrayList<Integer> userNumberList) {
        int count = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (randomNumberList.get(i) == userNumberList.get(i)) {
                count++;
            }
        }
        return count;
    }

    public static int getFinalBallCount(ArrayList<Integer> randomNumberList, ArrayList<Integer> userNumberList) {
        int count;
        count = compareBallCount(randomNumberList, userNumberList) - compareStrikeCount(randomNumberList, userNumberList);
        return count;
    }
}
