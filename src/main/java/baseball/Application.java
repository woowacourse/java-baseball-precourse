package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = initComputerNumbers();
    }

    public static List<Integer> initComputerNumbers() {
        List<Integer> list = new ArrayList<>();
        while (list.size() != 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(number)) {
                list.add(number);
            }
        }
        return list;
    }
}
