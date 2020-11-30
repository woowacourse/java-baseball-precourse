package baseball.controller;

import utils.RandomUtils;

public class RandomBallSet {
    static final int START_INDEX = 0;
    static final int END_INDEX = 9;
    static final int NUMBER_OF_BALL = 3;

    /**
     * 게임 진행을 위한 랜덤으로 선택되고 중복되지 않는 정수들로 이루어진 게임 세트 반환 메서드
     *
     * @return 랜덤으로 선택된 정수들의 배열
     */
    public static int[] ballSet() {
        int[] ballSet = new int[NUMBER_OF_BALL];
        boolean[] checkingOverlap = checkOverlapArray();
        int triedNumber = 0;
        while (triedNumber < NUMBER_OF_BALL) {
            int candidateNumber = RandomUtils.nextInt(START_INDEX, END_INDEX);
            int positionCandidateNumber = candidateNumber - 1;
            if (!checkingOverlap[positionCandidateNumber]) {
                ballSet[triedNumber] = candidateNumber;
                checkingOverlap[positionCandidateNumber] = true;
                triedNumber++;
            }
        }
        return ballSet;
    }

    private static boolean[] checkOverlapArray() {
        boolean[] checkingOverlapArray = new boolean[END_INDEX];
        for (int i = 0; i < END_INDEX; i++) {
            checkingOverlapArray[i] = false;
        }
        return checkingOverlapArray;
    }
}
