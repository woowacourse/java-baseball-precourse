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

    //숫자 입력 메세지 함수
    public void PrintNumMSG(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    //ball strike 개수
    public boolean BallStrikeNum(ArrayList<Integer> playerNum){
        int ballNum = 0;
        int strikeNum = 0;

        for(int i=0; i<3; i++){
            if(playerNum.get(i).equals(randomNum.get(i))){
                strikeNum++;
                continue;
            }
            if(setNum.contains(playerNum.get(i))) {
                ballNum++;
            }
        }

        return isBallStrike(ballNum, strikeNum);
    }

    //ball strike 출력 함수
    public boolean isBallStrike(int ballNum, int strikeNum){
        if(strikeNum == 3){
            Print3Strike();
            return true;
        } else if (strikeNum == 0 && ballNum == 0) {
            PrintNothing();
        } else {
            PrintBallStrike(ballNum, strikeNum);
        }

        return false;
    }

    public void Print3Strike(){
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void PrintNothing(){ System.out.println("낫싱"); }

    public void PrintBallStrike(int ballNum, int strikeNum){
        if(ballNum != 0 && strikeNum == 0) {
            System.out.println(ballNum + "볼");
        } else if(ballNum == 0 && strikeNum != 0) {
            System.out.println(strikeNum + "스트라이크");
        } else {
            System.out.println(ballNum + "볼 " + strikeNum + "스트라이크");
        }
    }
}
