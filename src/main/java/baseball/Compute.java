package baseball;

import utils.RandomUtils;

import java.util.ArrayList;

public class Compute {
    private static final int LENGTHNUMBER =3;
    private static final String BALL= "볼 ";
    private static final String STRIKE= "스트라이크 ";
    private static final String NOTHING="낫싱";
    private static final int MINRANGENUMBER=1;
    private static final int MAXRANGENUMBER=9;

    public ArrayList<Integer> getRandomNumber() {
        ArrayList<Integer> randomNumber= new ArrayList<Integer>();
        for(int i = 0; i< LENGTHNUMBER; i++) {
            if(randomNumber.size()==0){
                randomNumber.add(RandomUtils.nextInt(MINRANGENUMBER,MAXRANGENUMBER));
            }
            else{
                randomNumber.add(checkDuplicateNumber(randomNumber,RandomUtils.nextInt(MINRANGENUMBER,MAXRANGENUMBER)));
            }
        }
        return randomNumber;
    }
    public int checkDuplicateNumber(ArrayList<Integer> randomNumber,int number){
        boolean check=false;
        for(int i=0;i<randomNumber.size();i++){
            if(randomNumber.get(i)==number){
                check=true;
            }
        }
        if(check){
            return checkDuplicateNumber(randomNumber,RandomUtils.nextInt(MINRANGENUMBER,MAXRANGENUMBER));
        }
        else{
            return number;
        }
    }
    public int getStrikeNumber(ArrayList<Integer> inputNumber ,ArrayList<Integer> randomNumber){
        int strikeNumber=0;
        for(int i = 0; i< LENGTHNUMBER; i++){
            if(inputNumber.get(i)==randomNumber.get(i)){
                strikeNumber++;
            }
        }
        return strikeNumber;
    }
    public int getBallNumber(ArrayList<Integer> inputNumber , ArrayList<Integer> randomNumber){
        int ballNumber=0;
        for(int i = 0; i< LENGTHNUMBER; i++){
            if(checkBall(inputNumber.get(i),randomNumber)){
                ballNumber++;
            }
        }
        return ballNumber;
    }
    public boolean checkBall(int oneBallNumber,ArrayList<Integer> randomNumber){
        boolean check=false;
        for(int i=0;i<randomNumber.size();i++){
            if(oneBallNumber==randomNumber.get(i)){
                check=true;
            }
        }
        return check;
    }
    public String ballMessage(int ballCount,int strikeCount,String message)
    {
        if(ballCount>0 && strikeCount<3){
            message+=Integer.toString(ballCount);
            message+=BALL;
        }
        return message;
    }
    public String strikeMessage(int ballCount,int strikeCount,String message){
        if(strikeCount>0){
            message+=Integer.toString(strikeCount);
            message+=STRIKE;

        }
        return message;
    }
    public String nothingMessage(int ballCount,int strikeCount,String message){
        if(strikeCount<1 && ballCount<1){
            message+=NOTHING;
        }
        return message;
    }
}
