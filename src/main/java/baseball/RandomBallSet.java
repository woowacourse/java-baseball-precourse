package baseball;

import utils.RandomUtils;

public class RandomBallSet {
    static final int STARTINDEX = 0;
    static final int ENDINDEX = 9;
    static final int NUMBEROFBALL = 3;

    private RandomBallSet() {

    }

    public static int[] ballSet() {
        int[] ballSet = new int[NUMBEROFBALL];
        boolean [] checkingOverlap = checkOverlapArray(ENDINDEX);
        int triedNumber = 0;

        while (triedNumber < NUMBEROFBALL) {
            int candidateNumber = RandomUtils.nextInt(STARTINDEX, ENDINDEX);
            if (!checkingOverlap[candidateNumber - 1]) {
                ballSet[triedNumber] = candidateNumber;
                checkingOverlap[candidateNumber - 1] = true;
                triedNumber++;
            }
        }

        return ballSet;
    }

    private static boolean[] checkOverlapArray(int occasionNumber) {
        boolean [] checkingOverlapArray = new boolean[occasionNumber];

        for (int i =0; i < occasionNumber; i++) {
            checkingOverlapArray[i] = false;
        }

        return checkingOverlapArray;
    }
}
