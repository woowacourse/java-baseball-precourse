package baseball;

import java.util.HashSet;
import utils.RandomUtils;

public class NumberUtils {
    
    public static int validateInput(String inputString) {
        int numbers;
        for (int i = 0; i < inputString.length(); i++) {
            if (!Character.isDigit(inputString.charAt(i))) {
                throw new IllegalArgumentException("3자리 수가 아닙니다.");
            }
            if (inputString.charAt(i) == '0') {
                throw new IllegalArgumentException("1 부터 9까지의 수를 입력해 주세요.");
            }
        }
        numbers = Integer.parseInt(inputString);
        if (numbers < 100 || numbers > 1000) {
            throw new IllegalArgumentException("3자리 수가 아닙니다.");
        }
        return numbers;
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
