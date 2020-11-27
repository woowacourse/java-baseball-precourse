package baseball;

import java.util.ArrayList;
import utils.RandomUtils;

public class AnswerGenerator {

    private static final int START_INT = 123;
    private static final int END_INT = 987;

    ArrayList<Integer> answer;
    NumberValidator validator = new NumberValidator(answer);
    {
        do {
            answer = generateRandomNumbers();
            validator.numbers = answer;
        } while (!validator.isValid());
    }

    private static String generateRandomNumberString() {
        return Integer.toString(RandomUtils.nextInt(START_INT, END_INT));
    }


    private static ArrayList<Integer> generateRandomNumbers() {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        String RandomNumberString = generateRandomNumberString();
        for (int i = 0; i < RandomNumberString.length(); i++) {
            randomNumbers.add(Character.getNumericValue(RandomNumberString.charAt(i)));
        }
        return randomNumbers;
    }
}
