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
    

}
