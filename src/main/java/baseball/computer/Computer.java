package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Computer {
    //맞춰야 할 숫자
    public int[] target = new int[3];

    //Computer 인스턴스 생성시 target 만들어짐
    public Computer() {

        LinkedHashSet<Integer> targetSet = makeTargetSet();
        target = setToIntArray(targetSet);

    }

    private LinkedHashSet<Integer> makeTargetSet() {
        LinkedHashSet<Integer> targetSet = new LinkedHashSet<>();
        while (targetSet.size() < 3) {
            targetSet.add(pickNumberInRange(1, 9));
        }
        return targetSet;
    }

    private int[] setToIntArray(LinkedHashSet<Integer> targetSet) {
        int[] array = new int[3];
        Object[] objects = targetSet.toArray();

        for (int i = 0; i < 3; i++) {
            array[i] = (int) objects[i];
        }

        return array;
    }
}