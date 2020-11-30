package baseball;

import java.util.Arrays;
import utils.RandomUtils;

public class MakeRandomThreeNumber {
    private static int findNotEqualNumber(int[] arr){
        int i=0;
        int newNumber = RandomUtils.nextInt(1,9);
        while(i<arr.length){
            if(newNumber != arr[i]){
                i++;
            }
            else{
                i=0;
                newNumber = RandomUtils.nextInt(1,9);
            }
        }
        return newNumber;
    }

    public static int[] makeRandomThreeNumber(){
        int [] randomThreeNumber = new int[3];

        for(int i=0;i<3;i++){
            randomThreeNumber[i] = findNotEqualNumber(randomThreeNumber);
        }
        return randomThreeNumber;
    }
}
