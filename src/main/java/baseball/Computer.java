package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private int[] answer;

    public Computer() {
        List<Integer> numberList = makeList();
        answer = new int[3];
        chooseAnswer(numberList);
    }

    private void chooseAnswer(List<Integer> numberList) {
        for (int i = 0; i < 3; i++) {
            int randomNum = Randoms.pickNumberInList(numberList);
            int deleteIndex = numberList.indexOf(randomNum);
            numberList.remove(deleteIndex);
            answer[i] = randomNum;
        }
    }

    private List<Integer> makeList() {
        List<Integer> randomList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            randomList.add(i);
        }

        return randomList;
    }

    public int[] getAnswer() {
        return answer;
    }
}
