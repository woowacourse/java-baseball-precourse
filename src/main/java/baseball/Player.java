package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int INIT_LIST_SIZE = 3;
    private static final List<Integer> numbers = new ArrayList<>(INIT_LIST_SIZE);

    public void initNumbers() {
        numbers.clear();
        System.out.print("숫자를 입력해주세요 : ");
        String userNumberStr = Console.readLine();
        checkUserNumberStr(userNumberStr);
        userNumberStr
                .chars()
                .mapToObj(c -> c - '0')
                .forEach(numbers::add);
    }

    private void checkUserNumberStr(String userNumberStr) {
        if (userNumberStr.length() != INIT_LIST_SIZE)
            throw new IllegalArgumentException();
        long count = userNumberStr.chars()
                .filter(c -> '0' <= c && c <= '9')
                .count();
        if (count != 3)
            throw new IllegalArgumentException();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
