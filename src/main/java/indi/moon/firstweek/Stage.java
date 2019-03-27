package indi.moon.firstweek;

import java.util.Arrays;

public class Stage implements Stageface {

    User user = new User();
    Computer computer = new Computer();
    Referee referee = new Referee();

    @Override
    public void singlePlay() {
        System.out.println("싱글플레이를 시작합니다.");
//        int[] problem = computer.makeRandomNum();
        int[] problem = {1,2,3};
        while(true) {
            int[] answer = user.receiveNum();
            int[] result = check(problem,answer);
            if(result[0] == 3){
                System.out.println("정답을 맞췄습니다.");
                break;
            }
            checkLog(result);
        }
    }
    @Override
    public void multiPlay(){
        System.out.println("멀티플레이를 시작합니다.");
    }

    @Override
    public int[] check(int[] problem,int[] answer){
        int strike = referee.countStrike(problem,answer);
        int ball = referee.countBall(problem,answer) - strike;
        int[] counter = {strike,ball};
        return counter;
    }

    @Override
    public String checkLog(int[] result){
        String log = result[0]+"스트라이크\n"+result[1]+"볼";
        if(result[0] == 0 && result[1] ==0){
            log = "포볼";
        }
        System.out.println(log);
        return log;
    }
}