package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Computer {
    private ArrayList<Integer> computerNumbers;

    private Computer() {
        this.computerNumbers = new ArrayList<>();
    }

    private static class ComputerHolder {
        public static final Computer COMPUTER_INSTANCE = new Computer();
    }

    public static Computer getInstance() {
        return ComputerHolder.COMPUTER_INSTANCE;
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public void setNumbers() {
        computerNumbers.clear();
        List<Integer> baseNumber = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        shuffleNum(baseNumber);
        for (int i = 0; i < 3; i++) {
            computerNumbers.add(baseNumber.get(i));
        }
    }

    private void shuffleNum(List<Integer> numbers) {
        Collections.shuffle(numbers);
    }
}
