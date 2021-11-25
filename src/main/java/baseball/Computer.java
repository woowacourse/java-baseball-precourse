package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    private static final int SIZE_RANGE = 3;
    private static Set<Integer> randomNumbers;

    public Computer() {
        this.randomNumbers = new HashSet<>();
        this.setRandomNumbers();
    }

    public static void setRandomNumbers() {
        while (randomNumbers.size() < SIZE_RANGE) {
            int choice = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            randomNumbers.add(choice);
        }
    }

    public ArrayList<Integer> convertToList() {
        ArrayList<Integer> computerNumbers = new ArrayList<>();
        for (Integer i : randomNumbers)
            computerNumbers.add(i);
        return computerNumbers;
    }

    public void clear() {
        randomNumbers.clear();
    }

    public String toString() {
        return randomNumbers.toString();
    }
}
