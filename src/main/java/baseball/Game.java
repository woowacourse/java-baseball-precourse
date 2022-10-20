package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;
public class Game {

    private static String STRIKE = "스트라이크";
    private static String BALL = "볼";
    private static String NOTHING = "낫싱";

    Ball comBalls;
    Ball humanBalls;

    public Game() {
    }
    public static void play(){
        do {
            start();
        }
        while(restart());
    }
    public static void start(){

    }
    public static boolean restart(){

        return false;
    }
    public void makeComBalls() {
        List<Integer> list = comBalls.ball;
        while (list.size() != 3) {
            int a = Randoms.pickNumberInRange(1, 9);
            if(!comBalls.contains(a))
                list.add(a);
        }
        comBalls= (Ball) list;
    }
    public void makeHumanBalls(){
        List<Integer> list = humanBalls.ball;
        while (list.size() != 3) {
            int a = Integer.parseInt(Console.readLine());
           //validate만들어야함
        }
        humanBalls= (Ball) list;

    }
    public void validate(){
        //1.숫자의 범위(1~9), 2.겹치지 않게 두 개로 나눠야 함.
    }
    //check 함수 - 스트라잌, 볼 체크 strike,ball 만들어서 하나씩 올림
    //nothing 함수 - strike, ball 둘다 0이면
    //print함수 - 결과 출력
}

