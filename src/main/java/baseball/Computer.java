package baseball;

import java.util.ArrayList;

import java.util.LinkedHashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    private static final int SIZE_RANGE = 3;
    private static Set<Integer> randomNumbers;
    private static BoundaryChecker boundaryChecker;

    public Computer() {
        this.randomNumbers = new LinkedHashSet<>();
        this.boundaryChecker = new BoundaryChecker();
        this.setRandomNumbers();
    }

    public void setRandomNumbers() {
        while (randomNumbers.size() < SIZE_RANGE) {
            int choice = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            randomNumbers.add(choice);
        }
        boundaryChecker.checkRange(Integer.parseInt(toString()));
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

    @Override
    public String toString() {
        return randomNumbers.toString().replaceAll("[^0-9]", "");
    }
}
