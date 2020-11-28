package baseball;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Compute {
    private static final int lengthNumber=3;
    public List getRandomNumber() {
        ArrayList<Integer> randomNumber= new ArrayList<Integer>();
        for(int i=0;i<lengthNumber;i++) {
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
        for(int i=0;i<lengthNumber;i++){
            if(inputNumber.get(i)==randomNumber.get(i)){
                strikeNumber++;
            }
        }
        return strikeNumber;
    }
}
