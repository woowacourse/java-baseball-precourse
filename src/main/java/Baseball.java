import java.util.Arrays;
import java.util.Random;

public class Baseball {
    private static String secretNumber;

    public static void main(String[] args) {
        secretNumber = makeDifferentNumbers();
    }

    private static String makeDifferentNumbers() {
        int countOfCards = 3;
        int[] randomNumbers = new int[countOfCards];
        Random random = new Random();

        int i = 0;
        while (i < countOfCards) {
            int newRandomNumber = (random.nextInt(9));
            if (!isDuplicates(randomNumbers, newRandomNumber)) {
                randomNumbers[i] = newRandomNumber;
                i++;
            }
        }
        return Arrays.toString(randomNumbers).replaceAll("[^0-9]", "");
    }

    private static boolean isDuplicates(int[] array, int num) {
        for (int value : array) {
            if (value == num) {
                return true;
            }
        }
        return false;
    }

}
