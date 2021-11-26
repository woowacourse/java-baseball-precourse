package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class UniqueNumberFactory {

    private static final int NUMBER_SIZE = 3;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    public static Number create() {
        final Set<Integer> hashSet = new HashSet<>();

        while (hashSet.size() < NUMBER_SIZE) {
            final int number = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            hashSet.add(number);
        }

        return new Number(hashSet);
    }
}
