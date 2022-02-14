package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private char[] answer;

    public Computer() {
        List<Integer> numberList = makeList();
        answer = new char[3];

        for (int i = 0; i < 3; i++) {
            int randomNum = Randoms.pickNumberInList(numberList);
            numberList.remove(randomNum - 1);
            answer[i] = (char) (randomNum + '0');
        }
    }

    private List<Integer> makeList() {
        List<Integer> randomList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            randomList.add(i);
        }
        return randomList;
    }
}
