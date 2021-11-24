package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;

public class Game {

    private static final int NUMBER_LENGTH = 3;
    private int randomNumber;

    public void init() {
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();

        while (hashSet.size() < NUMBER_LENGTH) {
            int pickedNumber = Randoms.pickNumberInRange(1, 9);
            hashSet.add(pickedNumber);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer number : hashSet) {
            stringBuilder.append(number);
        }

        randomNumber = Integer.parseInt(stringBuilder.toString());
    }

}
