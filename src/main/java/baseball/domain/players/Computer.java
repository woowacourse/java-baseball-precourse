package baseball.domain.players;

import baseball.domain.constants.ConstantsNumbers;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Computer {

    private List<Integer> computerNumbers;

    public static Computer getComputer() {
        Computer computer = new Computer();
        computer.computerNumberSetup();
        return computer;
    }

    public void computerNumberSetup() {
        computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < ConstantsNumbers.COMPUTER_SIZE) {
            createComputerNumber();
        }
    }

    private void createComputerNumber() {
        int number = Randoms.pickNumberInRange(ConstantsNumbers.RANDOM_START_NUMBER, ConstantsNumbers.RANDOM_END_NUMBER);
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
