package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Random;

public class Application {
    public static void main(String[] args) {
        int flag = 1;
//        flag 가 2가 되면 while 문이 종료되면서 게임 종료
        while (flag == 1) {
            int[] randomNum = randomNum();
        }
    }
//    랜덤으로 숫자 3개를 생성하는 매소드
    private static int[] randomNum() {
        int first = Randoms.pickNumberInRange(1, 9);
        int second;
        int third;
        while (true) {
            second = Randoms.pickNumberInRange(1, 9);
            if (second != first) break;
        }
        while (true) {
            third = Randoms.pickNumberInRange(1, 9);
            if (third != second && third != first) break;
        }
        int[] randomNum = {first,second,third};
        return  randomNum;
    }
}
