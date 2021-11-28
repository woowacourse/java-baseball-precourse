package baseball;

import java.util.LinkedHashSet;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    private static final int NUMBER_LENGTH = 3;

    public static void main(String[] args) {
        System.out.println(generateRandomNumber());
    }

    public static String generateRandomNumber() {
        LinkedHashSet<Integer> randomNumberSet = new LinkedHashSet<>();

        while (randomNumberSet.size() < NUMBER_LENGTH) {
            int pickedNumber = Randoms.pickNumberInRange(1, 9);
            randomNumberSet.add(pickedNumber);
        }

        StringBuilder randomNumber = new StringBuilder();
        for (Integer number : randomNumberSet) {
            randomNumber.append(number);
        }

        return randomNumber.toString();
    }
}
