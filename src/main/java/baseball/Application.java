package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현

        //먼저 랜덤 3자리 숫자를 뽑는다. - 배열로 관리
        List<Integer> computer = new ArrayList<>(3);
        for (int i = 0; i < 3; i++){
            computer.set(i, pickNumberInRange(1, 9));
        }



    }
}
