package baseball;

import utils.RandomUtils;

import java.util.*;

public class RandomNumber {
    //랜덤 숫자를 3개 뽑을 것이기 때문에 상수로 3 설정
    static final int RAND_NUM_LENGTH = 3;

    static final int START_BOUND = 1;
    static final int END_BOUND = 9;

    //set을 이용하여 중복을 검사하면서 세 숫자를 리스트로 반환
    public List<Integer> makeThreeRandNum() {
        Set<Integer> threeNum = new HashSet<>();
        while (threeNum.size() < RAND_NUM_LENGTH) {
            threeNum.add(RandomUtils.nextInt(START_BOUND, END_BOUND));
        }
        return new ArrayList<>(threeNum);
    }


}
