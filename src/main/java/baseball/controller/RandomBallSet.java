package baseball.controller;

import utils.RandomUtils;

public class RandomBallSet {
    static final int STARTINDEX = 0;
    static final int ENDINDEX = 9;
    static final int NUMBEROFBALL = 3;

    public RandomBallSet() {

    }

    public static int[] ballSet() {
        int[] ballSet = new int[NUMBEROFBALL];
        boolean[] checkingOverlap = checkOverlapArray();
        int triedNumber = 0;

        while (triedNumber < NUMBEROFBALL) {
            int candidateNumber = RandomUtils.nextInt(STARTINDEX, ENDINDEX);
            int positionCandidateNumber = candidateNumber -1;
            if (!checkingOverlap[positionCandidateNumber]) {
                ballSet[triedNumber] = candidateNumber;
                checkingOverlap[positionCandidateNumber] = true;
                triedNumber++;
            }
        }

        return ballSet;
    }

    private static boolean[] checkOverlapArray() {
        boolean[] checkingOverlapArray = new boolean[ENDINDEX];

        for (int i = 0; i < ENDINDEX; i++) {
            checkingOverlapArray[i] = false;
        }

        return checkingOverlapArray;
    }
}
