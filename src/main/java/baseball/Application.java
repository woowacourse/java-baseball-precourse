package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = initComputerNumbers();
        List<Integer> user = initUserNumbers();
    }

    private static List<Integer> initComputerNumbers() {
        List<Integer> list = new ArrayList<>();
        while (list.size() != 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(number)) {
                list.add(number);
            }
        }
        return list;
    }

    private static List<Integer> initUserNumbers() {
        String userNumberStr = Console.readLine();
        checkUserNumberStr(userNumberStr);
        return userNumberStr
                .chars()
                .mapToObj(c -> c - '0')
                .collect(Collectors.toList());
    }

    private static void checkUserNumberStr(String userNumberStr) {
        if (userNumberStr.length() != 3)
            throw new IllegalArgumentException();
        long count = userNumberStr.chars()
                .filter(c -> '0' <= c && c <= '9')
                .count();
        if (count != 3)
            throw new IllegalArgumentException();
    }
}
