package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayTheGame {

    private static final String BALL= "볼 ";
    private static final String STRIKE= "스트라이크 ";
    private static final String ENDGAMEMESSAGE= "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    private static final String QUESTIONGAME= "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    Compute compute = new Compute();
    Player player = new Player();
    public void startingGame(){
        countingGame(player.getInputToArrayList(),compute.getRandomNumber());
    }
    public void countingGame(ArrayList<Integer> inputNumber,ArrayList<Integer> randomNumber){
        String message="";

        int ballCount=compute.getBallNumber(inputNumber,randomNumber);
        if(ballCount>0){
            message+=Integer.toString(ballCount);
            message+=BALL;
        }

        int strikeCount=compute.getStrikeNumber(inputNumber,randomNumber);
        if(strikeCount>0){
            message+=Integer.toString(strikeCount);
            message+=STRIKE;
        }
        if(strikeCount<1 && ballCount<1){
            message+="낫싱";
        }
        System.out.println(message);
        judgeGame(ballCount,strikeCount);
    }
    public void judgeGame(int ballCount,int strikeCount){
        if(strikeCount==3){
            System.out.println(ENDGAMEMESSAGE);
            System.out.println(QUESTIONGAME);
        }
        else{

            countingGame(player.getInputToArrayList(),compute.getRandomNumber());
        }
    }




}
