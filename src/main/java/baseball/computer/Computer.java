package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

import static baseball.Constants.maxNumberLen;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Computer {
    //맞춰야 할 숫자
    public int[] target;

    //Computer 인스턴스 생성시 target 만들어짐
    public Computer() {

        LinkedHashSet<Integer> targetSet = makeTargetSet();
        target = setToIntArray(targetSet);

    }

    private LinkedHashSet<Integer> makeTargetSet() {
        LinkedHashSet<Integer> targetSet = new LinkedHashSet<>();
        while (targetSet.size() < maxNumberLen) {
            targetSet.add(pickNumberInRange(1, 9));
        }
        return targetSet;
    }

    private int[] setToIntArray(LinkedHashSet<Integer> targetSet) {
        int[] array = new int[maxNumberLen];
        Object[] objects = targetSet.toArray();

        for (int i = 0; i < maxNumberLen; i++) {
            array[i] = (int) objects[i];
        }

        return array;
    }
}