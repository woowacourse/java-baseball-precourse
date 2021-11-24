package baseball;

import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현

        // 1. 타겟 넘버 생성
        int[] randomAns = createTargetNum();

        // 2. 유저에게 입력 받기


        // 3. 유저에게 결과 알려주기


        // 4. 재실행 여부
    }

    static public int[] createTargetNum(){
        int[] randomAns = new int[3];
        boolean[] check = new boolean[10];
        for(int i=0; i<3; i++){
            int num = Randoms.pickNumberInRange(1,4);

            while(check[num]){
                num = Randoms.pickNumberInRange(1,4);
            }

            check[num] = true;
            randomAns[i] = num;
        }
        return randomAns;
    }

}
