package baseball;

import java.util.List;

public class Game {

    //스트라이크 횟수를 반환하는 메서드
    public int strike(List<Integer> myNum, List<Integer> randNum) {
        int strike = 0;
        for (int i = 0; i < myNum.size(); i++) {
            if (myNum.get(i).equals(randNum.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    //볼 횟수를 반환하는 메서드
    public int ball(List<Integer> myNum, List<Integer> randNum) {
        int ball = 0;
        for (int i = 0; i < myNum.size(); i++) {
            if ((randNum.get(0).equals(myNum.get(i))) && (i != 0)) {
                ball++;
                break;
            }
        }
        for (int i = 0; i < myNum.size(); i++) {
            if ((randNum.get(1).equals(myNum.get(i))) && (i != 1)) {
                ball++;
                break;
            }
        }
        for (int i = 0; i < myNum.size(); i++) {
            if ((randNum.get(2).equals(myNum.get(i))) && (i != 2)) {
                ball++;
                break;
            }
        }
        return ball;
    }

}
