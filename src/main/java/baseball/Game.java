package baseball;

import java.util.List;

public class Game {

    MyNumber myNumber = new MyNumber();


    public int strike(List<Integer> myNum, List<Integer> randNum) {
        int strike = 0;
        for(int i=0; i< myNum.size(); i++) {
            if(myNum.get(i).equals(randNum.get(i))) {
                strike++;
            }
        }
        return strike;
    }
    public int ball(List<Integer> myNum, List<Integer> randNum) {
        int ball = 0;
        for(int i=0; i<myNum.size(); i++) {
            if((randNum.get(0).equals(myNum.get(i))) && (i != 0)) {
                ball++;
                break;
            }
        }
        for(int i=0; i<myNum.size(); i++) {
            if((randNum.get(1).equals(myNum.get(i))) && (i != 1)) {
                ball++;
                break;
            }
        }
        for(int i=0; i<myNum.size(); i++) {
            if((randNum.get(2).equals(myNum.get(i))) && (i != 2)) {
                ball++;
                break;
            }
        }
        return ball;
    }
    public boolean result(int strike, int ball) {

        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        if (strike == 3) {
            System.out.println();
            System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        }
        System.out.println();
        return false;
    }

}
