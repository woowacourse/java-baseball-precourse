package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> deck;

    public Computer() {
        this.deck = new ArrayList<>();
        int count = 0;
        while (count < 3) {

            Integer num = Randoms.pickNumberInRange(1, 9);
            if (deck.contains(num)) {
                continue;
            }
            deck.add(num);
            count++;
        }
    }
}
