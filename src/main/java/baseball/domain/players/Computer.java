package baseball.domain.players;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Computer {

    private List<Integer> computerNumbers = new ArrayList<>();

    public void computerNumberSetup() {

        while(computerNumbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 10);
            if(isContain(number)) {
                continue;
            }
        }
    }

    private boolean isContain(int number) {
        if(computerNumbers.contains(number)) {
           return true;
        }
        computerNumbers.add(number);
        return false;
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
