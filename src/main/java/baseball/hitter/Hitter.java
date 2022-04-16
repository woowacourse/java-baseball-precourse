package baseball.hitter;

import static baseball.hitter.HittingResult.BALL;
import static baseball.hitter.HittingResult.NOTHING;
import static baseball.hitter.HittingResult.STRIKE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class Hitter {

    private final List<Integer> hittingList;

    public Hitter() {
        this(getRandomHittingList());
    }

    public Hitter(List<Integer> hittingList) {
        this.hittingList = hittingList;
        assertHittingList();
    }

    public HittingResult hit(int index, int pitching) {
        assertHittingIndex(index);
        assertPitching(pitching);

        if (hittingList.get(index) == pitching) {
            return STRIKE;
        } else if (hittingList.contains(pitching)) {
            return BALL;
        }
        return NOTHING;
    }

    private void assertHittingList() {
        if (hittingList == null) {
            throw new IllegalArgumentException("hitting 은 null 입니다");
        } else if (hittingList.size() != 3) {
            throw new IllegalArgumentException("3개의 hitting 을 제시해야합니다");
        } else if (new HashSet<>(hittingList).size() != hittingList.size()) {
            throw new IllegalArgumentException("각각의 hitting 은 서로 달라야합니다");
        }
        for (Integer integer : hittingList) {
            assertHitting(integer);
        }
    }

    private void assertHittingIndex(int index) {
        if (index < 0 || hittingList.size() - 1 < index) {
            throw new IllegalArgumentException("hit index 는 0~2 사이만 가능합니다");
        }
    }

    private void assertPitching(Integer pitching) {
        if (pitching < 0 || 9 < pitching) {
            throw new IllegalArgumentException("pitching 은 0~9 사이의 수를 가질 수 있습니다");
        }
    }

    private void assertHitting(Integer hitting) {
        if (hitting < 0 || 9 < hitting) {
            throw new IllegalArgumentException("hitting 은 0~9 사이의 수를 가질 수 있습니다");
        }
    }

    private static List<Integer> getRandomHittingList() {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        while (set.size() < 3) {
            set.add(Randoms.pickNumberInRange(0, 9));
        }
        return new ArrayList<>(set);
    }
}
