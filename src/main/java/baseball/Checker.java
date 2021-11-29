package baseball;

import java.util.Arrays;

public class Checker {

    public Data check(String answer, String input) {
        boolean[] used = new boolean[10];
        Arrays.fill(used, false);

        for (int i = 0; i < 3; i++) used[answer.charAt(i) - '0'] = true;

        Data data = new Data();

        for (int i = 0; i < 3; i++) {
            char ch = input.charAt(i);
            if (!used[ch - '0']) continue;

            if (ch == answer.charAt(i)) data.addStrike();
            else data.addBall();
        }

        return data;
    }

}
