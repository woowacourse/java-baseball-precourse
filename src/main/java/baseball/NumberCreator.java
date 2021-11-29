package baseball;

import java.util.Random;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class NumberCreator {

    public String create() {
        Random random = new Random();

        while (true) {
            int a = pickNumberInRange(1, 9);
            int b = pickNumberInRange(1, 9);
            int c = pickNumberInRange(1, 9);

            if(a == b || a == c || b == c) continue;
            return String.valueOf(100 * a + 10 * b + c);
        }
    }

}
