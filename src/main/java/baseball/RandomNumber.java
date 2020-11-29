package baseball;

import utils.RandomUtils;

public class RandomNumber {
    //랜덤 숫자를 3개 뽑을 것이기 때문에 상수로 3 설정
    static final int RAND_NUM_LENGTH = 3;

    //세 개의 한자리 랜덤 숫자를 배열로 반환. 중복검사는 하지 않음
    private int[] makeThreeRandNum() {
        int[] threeNum = new int[RAND_NUM_LENGTH];
        for (int i = 0; i < threeNum.length; i++) {
            threeNum[i] = RandomUtils.nextInt(1, 9);
        }
        return threeNum;
    }

}
