package baseball;

import utils.RandomUtils;
import java.util.ArrayList;
import java.util.List;

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

    //세 숫자가 서로 중복되는지 체크하는 메서드
    private boolean checkDuplication(int n1, int n2, int n3) {
        return (n1 != n2) && (n2 != n3) && (n3 != n1);
    }

    //중복검사를 완료한 세 숫자를 리스트로 반환하는 메서드
    public List<Integer> randNumList() {
        while (true) {
            List<Integer> list = new ArrayList<>(RAND_NUM_LENGTH);
            int[] randNum = makeThreeRandNum();
            if (checkDuplication(randNum[0], randNum[1], randNum[2])) {
                list.add(randNum[0]);
                list.add(randNum[1]);
                list.add(randNum[2]);
                return list;
            }
        }
    }

}
