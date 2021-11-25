package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class Computer {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int LENGTH_NUMBER = 3;

    public static String generateNumbers() {
        int[] computerNumbers = new int[LENGTH_NUMBER];

        int i = 0;
        do {
            computerNumbers[i] = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (i > 0 && computerNumbers[i] == computerNumbers[i - 1]) {
                continue;
            }
            i = i + 1;
        } while (i < LENGTH_NUMBER);

        return Arrays.toString(computerNumbers);
    }

    public static void main(String[] args) {
        System.out.println(generateNumbers());
    }
}
