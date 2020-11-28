package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayTheGame {
    private static final String INPUTNUMBER = "숫자를 입력해주세요:";
    private static final String BALL= "볼 ";
    private static final String STRIKE= "스트라이크 ";
    private static final String ENDGAMEMESSAGE= "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    private static final String QUESTIONGAME= "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요:";
    Compute compute = new Compute();
    Scanner scanner = new Scanner(System.in);
    public void startingGame(){


        System.out.print(INPUTNUMBER);


        int input=scanner.nextInt();
        String convertInput=Integer.toString(input);
        ArrayList<Integer> inputNumber= new ArrayList<Integer>();
        for(int i=0;i<3;i++){
            inputNumber.add(convertInput.charAt(i)-'0');
        }

        countingGame(inputNumber,compute.getRandomNumber());
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
            int input=scanner.nextInt();
            String convertInput=Integer.toString(input);
            ArrayList<Integer> inputNumber= new ArrayList<Integer>();
            for(int i=0;i<3;i++){
                inputNumber.add(convertInput.charAt(i)-'0');
            }
            countingGame(inputNumber,compute.getRandomNumber());
        }
    }




}
