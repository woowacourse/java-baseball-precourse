package baseball;

import java.util.ArrayList;

public class NumberCompare {

    private static final int NUMBER_LENGTH = 3;
    private static ArrayList<Integer> randomNumberList = new ArrayList<>();
    private static ArrayList<Integer> userNumberList = new ArrayList<>();
    private static ArrayList<Integer> ballStrikeCountList = new ArrayList<>();

    public NumberCompare(ArrayList<Integer> randomNumberList, ArrayList<Integer> userNumberList) {
        this.randomNumberList = randomNumberList;
        this.userNumberList = userNumberList;
    }

    public static ArrayList<Integer> numberCompare() {
        ballStrikeCountList.clear();
        ballStrikeCountList.add(getFinalBallCount());
        ballStrikeCountList.add(compareStrikeCount());

        return ballStrikeCountList;
    }

    public static int compareBallCount() {
        int count = 0;
        for (int singleUserNumber : userNumberList) {
            if (randomNumberList.contains(singleUserNumber)) {
                count++;
            }
        }
        return count;
    }

    public static int compareStrikeCount() {
        int count = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (userNumberList.get(i).equals(randomNumberList.get(i))) {
                count++;
            }
        }
        System.out.println(count);
        return count;
    }

    public static int getFinalBallCount() {
        int count = 0;
        count = compareBallCount() - compareStrikeCount();
        return count;
    }
}
