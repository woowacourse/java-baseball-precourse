package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Computer {
    ArrayList<Integer> randomNum = new ArrayList<>(); //순서 상관o
    Set<Integer> setNum = new HashSet<>(); //순서 상관x

    //랜덤 세자리 수 생성 함수
    public void RandomNum(){
        while(randomNum.size() <3) {
            int num = Randoms.pickNumberInRange(1, 9); // 1~9까지
            if (!randomNum.contains(num)) {
                randomNum.add(num);
                setNum.add(num);
            }
        }
    }
}
