package baseball.gamesource;

import java.util.ArrayList;
import java.util.List;

import baseball.constants.ValueConstants;

import camp.nextstep.edu.missionutils.Randoms;

public class Opponent {
    private List<Integer> numbers= new ArrayList<>();

    public Opponent(){  //생성자에서 서로 다른 세가지 난수 생성

        for(int i=0; i< ValueConstants.GAME_NUMBER_LEN ; ++i){
            int randomNum;

            do{ // 중복 값 배제
                randomNum = Randoms.pickNumberInRange(ValueConstants.GAME_NUMBER_BOUND_START,ValueConstants.GAME_NUMBER_BOUND_END);
            }while(numbers.contains(randomNum));

            numbers.add(randomNum);
        }

    }

    List<Integer> getNumbers(){
        return numbers;
    }

}
