package baseball.computer;

import baseball.pitch.Pitch;
import baseball.valid.Valid;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Computer implements Valid {
    private final List<Integer> numberList;
    private final boolean[] dup;
    private final int RAN_MIN = 1;
    private final int RAN_MAX = 9;
    private Set<Pitch> pitchSet;

    public Computer() {
        numberList = new ArrayList<>();
        dup = new boolean[10];
        for(int i=0; i<3; i++)
            fillList(Randoms.pickNumberInRange(RAN_MIN, RAN_MAX));
    }

    private void fillList(int i) {
        // 기존에 입력받은 값이면 다시 난수 생성
        while(dup[i]) {
            i = Randoms.pickNumberInRange(RAN_MIN, RAN_MAX);
        }
        numberList.add(i);
        dup[i] = true;
    }

    public void setPitchSet(Set<Pitch> pitchSet) {
        this.pitchSet = pitchSet;
    }
    public Set<Pitch> getPitchSet() {
        return pitchSet;
    }
    public List<Integer> getNumberList() {
        return numberList;
    }

}
