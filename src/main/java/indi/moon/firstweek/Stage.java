package indi.moon.firstweek;

import java.util.ArrayList;
import java.util.Arrays;

public class Stage implements Stageface {

    User user = new User();
    Computer computer = new Computer();
    Brain brain = new Brain();
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
        int[] result = {0,0,0};
        int[] countarr = {0};
        int[] totalCountarr = {0};
        ArrayList<int[]> TB = new ArrayList<int[]>();
        ArrayList<int[]> TS = new ArrayList<int[]>();
        ArrayList<int[]> Pre = new ArrayList<int[]>();
        ArrayList<int[]> resultedLog = new ArrayList<int[]>();
        ArrayList<int[]> count = new ArrayList<int[]>();
        ArrayList<int[]> totalCount = new ArrayList<int[]>();
        ArrayList<int[]> state = new ArrayList<int[]>();
        ArrayList number = new ArrayList();
        ArrayList []info = {TB,TS,Pre,resultedLog,count,totalCount,state};

//        int[] comnum = {3,2,1};
        int[] comnum;
        comnum = computer.makeRandomNum();
        System.out.println("랜덤값: "+ Arrays.toString(comnum));
        int[] problem = {1,2,3};

        number.clear();
        for(int i=1; i<11; i++) {
            number.add(i);
        }
        result = check(problem,comnum);
        for(int i =0; i<25; i++) {
            System.out.println("number: "+Arrays.toString(number.toArray()));
            System.out.println("학습할 데이터 :"+Arrays.toString(comnum)+"학습할 결과:"+Arrays.toString(result));
            info = brain.getLearningData(comnum,result,info,number);
            comnum = brain.getData(info);
            result = check(problem,comnum);
            System.out.println("comnum: "+ Arrays.toString(comnum));
            System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
            if(referee.indexOf(comnum,10)!=-1) {
                System.out.println("컴퓨터가 항복하였습니다.");
                break;
            }
            if(result[0]==3) {
                System.out.println("디엔드");
                break;
            }
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