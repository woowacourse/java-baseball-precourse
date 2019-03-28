package indi.moon.firstweek;

import java.util.ArrayList;

public class Stage implements Stageface {

    User user = new User();
    Computer computer = new Computer();
    Brain brain = new Brain();
    Referee referee = new Referee();
    Config config = new Config();

    @Override
    public void singlePlay() {
        System.out.println("싱글플레이를 시작합니다.");
//        int[] problem = computer.makeRandomNum();
        int[] problem = {1,2,3};
        while(true) {
            int[] answer = checkReceiveNum();
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
        String player = playStart();
        boolean playing = true;
        int[] userResult = new int[3];
        int[] comResult = new int[3];
        int[][] problem = makeAnswer();
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
        number.clear();
        for(int i=1; i<11; i++) {
            number.add(i);
        }
        int[] computerAnswer;
        computerAnswer = computer.makeRandomNum();

        while(playing){
            if (player == user.USER_NAME) {
                System.out.println("정답을 시도하세요");
                int[] userAnswer = checkReceiveNum();
                userResult = check(problem, userAnswer, player);
                checkLog(userResult);
                player = computer.COMPUTER_NAME;
                computer.lookComNum(computerAnswer);
                comResult = check(problem, computerAnswer, player);
                checkLog(comResult);
                playing = checkWinner(userResult,comResult);
                info = brain.getLearningData(computerAnswer,comResult,info,number);
                computerAnswer = brain.getData(info);
                player = user.USER_NAME;
            }else{
                computer.lookComNum(computerAnswer);
                comResult = check(problem, computerAnswer, player);
                checkLog(comResult);
                info = brain.getLearningData(computerAnswer,comResult,info,number);
                computerAnswer = brain.getData(info);
                player = user.USER_NAME;
                int[] userAnswer = checkReceiveNum();
                userResult = check(problem, userAnswer, player);
                checkLog(userResult);
                playing = checkWinner(userResult,comResult);
                player = computer.COMPUTER_NAME;
            }
            if(referee.indexOf(computerAnswer,10)!=-1) {
                System.out.println("컴퓨터가 항복하였습니다.");
                break;
            }
        }
    }

    @Override
    public int[] check(int[][] problem,int[] answer, String player){
        int strike = referee.countStrike(problem,answer,player);
        int ball = referee.countBall(problem,answer,player) - strike;
        int[] counter = {strike,ball};
        return counter;
    }

    public int[] check(int[] problem,int[] answer){
        int strike = referee.countStrike(problem,answer);
        int ball = referee.countBall(problem,answer) - strike;
        int[] counter = {strike,ball};
        return counter;
    }

    @Override
    public String checkLog(int[] result){
        String log = result[0]+"스트라이크\n"+result[1]+"볼\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ";
        if(result[0] == 0 && result[1] ==0){
            log = "포볼";
        }
        System.out.println(log);
        return log;
    }

    public String playStart(){
        boolean preOrder = config.choosePre();
        String prePlayer = "";
        if(preOrder){
            System.out.println("User님의 선공입니다.");
            prePlayer = user.USER_NAME;

        }else{
            System.out.println("Computer님의 선공입니다.");
            prePlayer = computer.COMPUTER_NAME;
        }
        return prePlayer;
    }

    public int[][] makeAnswer(){
        System.out.println("문제를 생성해주세요.");
        int[] myAnswer = user.receiveNum();
        while(myAnswer.length!=3){
            System.out.println("세자리수로 입력해 주세요.");
            myAnswer = user.receiveNum();
        }
        int[] comAnswer = computer.makeRandomNum();
        int[][] Answer = new int[2][3];
        Answer[0] = myAnswer;
        Answer[1] = comAnswer;
        return Answer;
    }

    public int[] checkReceiveNum(){
        int[] answer = user.receiveNum();
        if(answer.length!=3) {
            do {
                System.out.println("세자리수로 입력해 주세요.");
                answer = user.receiveNum();
            } while (answer.length != 3);
        }
        if(answer[0] == answer[1] ||answer[1] == answer[2]||answer[0] == answer[2]){
            do {
                System.out.println("중복된 값은 허용하지 않습니다.");
                answer = user.receiveNum();
            }while(answer[0] == answer[1] ||answer[1] == answer[2]||answer[0] == answer[2]);
        }
        return answer;
    }

    public boolean checkWinner(int[] userResult,int[] comResult){
        if(userResult[0]==3) {
            System.out.println("유저님이 승리하셨습니다!");
            return false;
        }
        if(comResult[0]==3) {
            System.out.println("컴퓨터가 승리하였습니다!");
            return false;
        }
        return true;
    }

}