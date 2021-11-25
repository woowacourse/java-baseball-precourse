package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * 컴퓨터의 정답 수를 만드는 클래스.
 * 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 랜덤으로 만든다.
 * pickNumberInRange() 메소드를 활용한다.
 */
public class ComputerNumber {
    private List<Integer> computerNumber;

    public ComputerNumber() {
        computerNumber = generateNumber();
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

    public List<Integer> generateNumber() {
        HashSet<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < 3) {
            int number =
                    Randoms.pickNumberInRange(InputNumberValidator.RANGE_START, InputNumberValidator.RANGE_END);
            numbers.add(number);
        }
        return new ArrayList<>(numbers);
    }
}
