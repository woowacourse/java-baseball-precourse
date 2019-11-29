/**
 * NumberGenerator 클래스에서는 플레이어가 맞춰야할 세자리수를 생성한다.
 */

import java.util.ArrayList;
import java.util.Random;

public class NumberGenerator {

    private static ArrayList<Integer> numberList;

    public static ArrayList<Integer> numberGenerator() {
        numberList = getRandomNonRepeatingIntegers(3, 1, 9);
        return numberList;
    }

    public static int getRandomInt(int min, int max) {
        Random random = new Random();

        return random.nextInt((max - min) + 1) + min;
    }

    public static ArrayList<Integer> getRandomNonRepeatingIntegers(int size, int min, int max) {
        ArrayList<Integer> numbers = new ArrayList<>();

        while (numbers.size() < size) {
            int random = getRandomInt(min, max);

            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }

        return numbers;
    }

}
