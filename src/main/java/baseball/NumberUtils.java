package baseball;

import java.util.HashSet;
import utils.RandomUtils;

public class NumberUtils {

    public static void validateInput(int numbers) {
        if (numbers < 100 || numbers > 1000) {
            throw new IllegalArgumentException("3자리 수가 아닙니다.");
        }
    }

    public static int[] createInputNumber(int numbers) {
        String temp = Integer.toString(numbers);
        int[] inputNumberArray = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            inputNumberArray[i] = temp.charAt(i) - '0';
        }
        return inputNumberArray;
    }

    public static int[] createRandomNumber() {
        int[] randomNumberArray = new int[3];
        HashSet<Integer> tempHashSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            int uniqueNumber = RandomUtils.nextInt(1, 9);
            while (tempHashSet.contains(uniqueNumber)) {
                uniqueNumber = RandomUtils.nextInt(1, 9);
            }
            tempHashSet.add(uniqueNumber);
            randomNumberArray[i] = uniqueNumber;
        }
        return randomNumberArray;
    }
}
