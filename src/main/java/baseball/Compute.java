package baseball;

import utils.RandomUtils;

import java.util.ArrayList;

public class Compute {
    private static final int LENGTHNUMBER =3;
    public ArrayList<Integer> getRandomNumber() {
        ArrayList<Integer> randomNumber= new ArrayList<Integer>();
        for(int i = 0; i< LENGTHNUMBER; i++) {
            if(randomNumber.size()==0){
                randomNumber.add(RandomUtils.nextInt(1,9));
            }
            else{
                randomNumber.add(checkDuplicateNumber(randomNumber,RandomUtils.nextInt(1,9)));
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
            return checkDuplicateNumber(randomNumber,number);
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
}
