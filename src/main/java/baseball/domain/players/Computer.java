package baseball.domain.players;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Computer {

    private List<Integer> computerNumbers = new ArrayList<>();
    private static final int COMPUTER_SIZE = 3;
    private static final int RANDOM_START_NUMBER = 1;
    private static final int RANDOM_END_NUMBER = 9;

    public void computerNumberSetup() {
        while (computerNumbers.size() < COMPUTER_SIZE) {
            createComputerNumber();
        }
    }

    private void createComputerNumber() {
        int number = Randoms.pickNumberInRange(RANDOM_START_NUMBER, RANDOM_END_NUMBER);
        isContain(number);
    }

    private void isContain(int number) {
        if (!computerNumbers.contains(number)) {
            computerNumbers.add(number);
        }
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Objects.equals(computerNumbers, computer.computerNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(computerNumbers);
    }
}
