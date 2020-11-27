package baseball;

import utils.RandomUtils;

public class Computer {

    public String makeRandomNumber(){
        String result = "";
        int digit = 0;
        while(digit < Constants.NUMBER_LEN){
            int number = RandomUtils.nextInt(Constants.MIN_NUMBER, Constants.MAX_NUMBER);

            if(!result.contains(String.valueOf(number))){
                result += number;
                digit++;
            }
        }

        return result;
    }
}
