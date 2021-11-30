package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import constant.SystemMessage;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public static List<Integer> generateNumbers(){
        List<Integer> numberList = new ArrayList<Integer>();
        while(true){
            numberList.add(Randoms.pickNumberInRange(SystemMessage.MIN_NUMBER,SystemMessage.MAX_NUMBER));
            if(numberList.size()==SystemMessage.COMPARE_LENGTH){
                break;
            }
        }
        return numberList;
    };

}
