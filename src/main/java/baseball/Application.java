package baseball;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        List<Integer> answerNumbersList = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        int inputNumber = Integer.parseInt(Console.readLine());
    }
}
