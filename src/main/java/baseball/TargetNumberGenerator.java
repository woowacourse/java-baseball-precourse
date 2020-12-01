package baseball;

import java.util.ArrayList;
import utils.RandomUtils;

public class TargetNumberGenerator {
    public ArrayList<Integer> targetNumber;

    public TargetNumberGenerator() {
        targetNumber = generateNumber();
    }

    public ArrayList<Integer> getTargetNumber() {
        return targetNumber;
    }

    private ArrayList<Integer> generateNumber() {
        ArrayList<Integer> numberList = new ArrayList<>();

        for (int digit = 0; digit < 3; digit++) {
            int generatedNumber = avoidRepeat(numberList);
            numberList.add(generatedNumber);
        }

        return numberList;
    }

    private int avoidRepeat(ArrayList<Integer> finalNumbers) {
        int randomNumber = RandomUtils.nextInt(1, 9);
        while (checkRepeat(finalNumbers, randomNumber)) {
            randomNumber = RandomUtils.nextInt(1, 9);
        }

        return randomNumber;
    }

    private boolean checkRepeat(ArrayList<Integer> finalNumbers, int candidateNumber) {
        return finalNumbers.contains(candidateNumber);
    }
}
