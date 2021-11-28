package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class RandomNumberGenerator {

    public String generateNumber() {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

        while(linkedHashSet.size() < 3) {
            linkedHashSet.add(Randoms.pickNumberInRange(1, 9));
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
