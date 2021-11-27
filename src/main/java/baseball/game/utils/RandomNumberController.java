package baseball.game.utils;

import baseball.game.constants.BaseballGameConst;
import camp.nextstep.edu.missionutils.Randoms;

import static baseball.game.constants.BaseballGameConst.*;

public class RandomNumberController {

    private boolean[] flag;


    public RandomNumberController(){
        for (boolean b : flag = new boolean[NINE + 1]) {
            b = false;
        }
    }

    public int[] getThreeRandomNumbers(){
        int[] returnValue = new int[RANDOM_NUMBER_COUNTS];

        for(int i=0;i<RANDOM_NUMBER_COUNTS;i++){
            returnValue[i] = getDistinctRandomNumber();
        }

        return returnValue;
    }

    private int getDistinctRandomNumber() {
        int ret = Randoms.pickNumberInRange(ONE, NINE);

        while(isExist(ret)){
            ret = Randoms.pickNumberInRange(ONE, NINE);
        }
        flag[ret] = true;
        return ret;
    }

    private boolean isExist(int ret) {

        return flag[ret];
    }
}
