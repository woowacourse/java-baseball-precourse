package indi.moon.firstweek;

import java.util.Arrays;

public class Stage implements Stageface {

    User user = new User();
    Computer computer = new Computer();
    Referee referee = new Referee();
    @Override
    public void play(String commend) {
        System.out.println("게임이 시작되었습니다.");
        int[] problem = computer.makeRandomNum();
        while(true) {
            int[] answer = user.receiveNum();
            int[] result = check(problem,answer);
            checkLog(result);
        }
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