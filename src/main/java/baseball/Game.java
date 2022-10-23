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

    int Strike =0;
    int Ball = 0;

    public Game() {
    }

    public void play(){
        do {
            start();
        }
        while(restart());
    }

    public void start(){
        comBalls = makeComBalls();
        humanBalls = makeHumanBalls();
    }

    public static boolean restart(){
        String a = readLine();
        if(a.equals("1")) return true;
        else return false;
    }

    public Ball makeComBalls() {
        List<String> list = comBalls.ball;
        while (list.size() != 3) {
            String a = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if(!comBalls.contains(a))
                list.add(a);
        }
        comBalls= (Ball) list;
        return comBalls;
    }

    public Ball makeHumanBalls(){
        List<String> list = humanBalls.ball;
        String a = "";
        while(a.equals("")){
            System.out.print("숫자를 입력해주세요 : ");
            a=readLine();
            if(humanBalls.validate(a)){
                String [] tmp = a.split("");
                for(int i=0;i<3;i++){
                    list.add(tmp[i]);
                }
                humanBalls= (Ball) list;
            }
            else{
                makeHumanBalls();
            }
        }
        return  humanBalls;
    }

    public void check(){

    }

    //check 함수 - 스트라잌, 볼 체크 strike,ball 만들어서 하나씩 올림
    //nothing 함수 - strike, ball 둘다 0이면
    //print함수 - 결과 출력
}

