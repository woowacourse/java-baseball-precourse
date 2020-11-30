package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayTheGame {
    private static final String ENDGAMEMESSAGE= "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    private static final String QUESTIONGAME= "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final int LENGTHNUMBER=3;
    Compute compute = new Compute();
    Player player = new Player();
    ArrayList<Integer> tmpSaveRandomNumber;

    public void startingGame(){
        saveRandomNumber(compute.getRandomNumber());
        countingGame(player.getInputToArrayList(), returnRandomNumber());
    }
    public void  saveRandomNumber(ArrayList<Integer> RandomNumber){
        this.tmpSaveRandomNumber=RandomNumber;
    }
    public ArrayList<Integer> returnRandomNumber(){
        return this.tmpSaveRandomNumber;
    }
    public void countingGame(ArrayList<Integer> inputNumber,ArrayList<Integer> randomNumber) throws IllegalArgumentException {
       
        String message="";
        int ballCount=compute.getBallNumber(inputNumber,randomNumber);
        int strikeCount=compute.getStrikeNumber(inputNumber,randomNumber);
        message= compute.ballMessage(ballCount,strikeCount,message);
        message=compute.strikeMessage(ballCount,strikeCount,message);
        message=compute.nothingMessage(ballCount,strikeCount,message);
        System.out.println(message);
        judgeGame(ballCount,strikeCount);
    }
    public void judgeGame(int ballCount,int strikeCount){
        if(strikeCount==3){
            System.out.println(ENDGAMEMESSAGE);
            System.out.println(QUESTIONGAME);
            int choiceNumber=player.getChoiceNumber();
            continuingGame(choiceNumber);
        }
        else{
            countingGame(player.getInputToArrayList(),returnRandomNumber());
        }
    }
    public void continuingGame(int choiceNumber){

        if(choiceNumber==1){
            startingGame();
        }
    }





}
