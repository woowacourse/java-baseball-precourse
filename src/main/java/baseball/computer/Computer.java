package baseball.computer;

import baseball.pitch.Pitch;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Set;

public class Computer {
    private final int num;
    private final int RAN_MIN = 100;
    private final int RAN_MAX = 999;
    private Set<Pitch> pitchSet;

    public Computer() {
        num = Randoms.pickNumberInRange(RAN_MIN, RAN_MAX);
    }
    public void setPitchSet(Set<Pitch> pitchSet) {
        this.pitchSet = pitchSet;
    }
    public Set<Pitch> getPitchSet() {
        return pitchSet;
    }
    public int getNumber() {
        return num;
    }
}
