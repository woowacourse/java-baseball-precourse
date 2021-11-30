package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameHelper {

    public static List<Integer> generateNumbers(){
        List<Integer> numberList = new ArrayList<Integer>();
        while(true){
            numberList.add(Randoms.pickNumberInRange(1,9));
            if(numberList.size()==3){
                break;
            }
        }
        return numberList;
    };

}
