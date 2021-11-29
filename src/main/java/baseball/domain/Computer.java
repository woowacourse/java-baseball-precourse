package baseball.domain;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    public static final int ANSWER_SIZE_LIMIT = 3;

    public static ArrayList<String> makeRandom(){
        ArrayList<String> numbers = new ArrayList<>();

        while(true){
            String number = String.valueOf(Randoms.pickNumberInRange(1, 9));

            if (!numbers.contains(number)){
                numbers.add(number);
            }

            if (numbers.size() == ANSWER_SIZE_LIMIT){
                return numbers;
            }
        }
    }
}
