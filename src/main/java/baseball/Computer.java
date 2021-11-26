package baseball;

import java.util.ArrayList;

import java.util.LinkedHashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import constant.MessageList;

public class Computer {
    private static Set<Integer> randomNumbers;
    private static BoundaryChecker boundaryChecker;

    public Computer() {
        this.randomNumbers = new LinkedHashSet<>();
        this.boundaryChecker = new BoundaryChecker();
        this.setRandomNumbers();
    }

    public void setRandomNumbers() {
        while (randomNumbers.size() < MessageList.SIZE_RANGE) {
            int choice = Randoms.pickNumberInRange(MessageList.START_RANGE, MessageList.END_RANGE);
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
        return randomNumbers.toString().replaceAll("[^0-9]", MessageList.NULL_STRING);
    }
}
