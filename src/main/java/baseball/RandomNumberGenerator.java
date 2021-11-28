package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Iterator;
import java.util.LinkedHashSet;

import static baseball.InitialSetting.*;

public class RandomNumberGenerator {

    public String generateNumber() {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

        while(linkedHashSet.size() < NUM_SIZE) {
            linkedHashSet.add(Randoms.pickNumberInRange(MIN_NUM_VALUE, MAX_NUM_VALUE));
        }

        return hashSetToString(linkedHashSet);
    }

    private String hashSetToString(LinkedHashSet<Integer> linkedHashSet) {
        Iterator<Integer> iter = linkedHashSet.iterator();
        StringBuilder value = new StringBuilder();

        while(iter.hasNext()) {
            value.append(iter.next());
        }

        return value.toString();
    }
}
