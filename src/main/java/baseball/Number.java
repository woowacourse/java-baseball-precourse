package baseball;

import utils.DuplicateChecker;
import utils.RandomUtils;

public class Number {

    private int[] target;
    private int[] guess;

    public Number() {
        target = new int[3];
        guess = new int[3];
    }

    public void setTarget(){
        for(int i = 0; i < 3; i++){
            int tmp = RandomUtils.nextInt(1, 9);
            if(!DuplicateChecker.checkDuplicateNumber(tmp)){
                target[i] = tmp;
            }
            else{
                i--;
            }
        }
    }

    public int[] getTarget(){
        return target;
    }


}
