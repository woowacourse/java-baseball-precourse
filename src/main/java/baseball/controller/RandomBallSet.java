package baseball.controller;

import utils.RandomUtils;

public class RandomBallSet {
    private static final int START_INDEX = 1;
    private static final int END_INDEX = 9;
    private static final int NUMBER_OF_BALL = 3;

    /**
     * 게임 진행을 위한 랜덤으로 선택되고 중복되지 않는 정수들로 이루어진 게임 세트 반환 메서드
     *
     * @return 랜덤으로 선택된 정수들의 배열
     */
    public static int[] ballSet() {
        int[] ballSet = new int[NUMBER_OF_BALL];
        boolean[] checkOverlapArray = checkOverlapGetArray();
        int insertedBallNumber = 0;
        while (insertedBallNumber < NUMBER_OF_BALL) {
            insertBall(insertedBallNumber, ballSet, checkOverlapArray);
            insertedBallNumber = checkInsertedBallNumber(checkOverlapArray);
        }
        return ballSet;
    }

    private static boolean[] checkOverlapGetArray() {
        boolean[] checkingOverlapGetArray = new boolean[END_INDEX];
        for (int i = 0; i < END_INDEX; i++) {
            checkingOverlapGetArray[i] = false;
        }
        return checkingOverlapGetArray;
    }

    private static void insertBall(int ballNumber, int[] ballSet, boolean[] overlapArray) {
        int candidateNumber = RandomUtils.nextInt(START_INDEX, END_INDEX);
        int positionCandidateNumber = candidateNumber - 1;
        if (!overlapArray[positionCandidateNumber]) {
            ballSet[ballNumber] = candidateNumber;
            overlapArray[positionCandidateNumber] = true;
        }
    }

    private static int checkInsertedBallNumber(boolean[] checkOverlapArray) {
        int insertedNumber = 0;
        for (int i=0; i<END_INDEX; i++) {
            if (checkOverlapArray[i]) {
                insertedNumber++;
            }
        }
        return insertedNumber;
    }
}
