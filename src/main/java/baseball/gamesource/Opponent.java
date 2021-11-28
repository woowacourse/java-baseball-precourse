package baseball.gamesource;

import java.util.ArrayList;
import java.util.List;

import baseball.constants.ValueConstants;

import camp.nextstep.edu.missionutils.Randoms;

public class Opponent {
    private List<Integer> numbers = new ArrayList<>();

    public Opponent(){  //생성자에서 랜덤 수 생성
        for(int i=0; i< ValueConstants.GAME_NUMBER_LEN ; ++i){
            int randomNum = (Randoms.pickNumberInRange(ValueConstants.GAME_NUMBER_BOUND_START,ValueConstants.GAME_NUMBER_BOUND_END));
            numbers.add(randomNum);
        }
    }

    List<Integer> getNumbers(){
        return numbers;
    }

}
