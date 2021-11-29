package baseball.game;

import baseball.pitch.Pitch;

import java.util.HashSet;
import java.util.Set;

public class Game {
    public Set<Pitch> getPitchSet(int num) {
        // 각 자리수별 만들 Pitch를 담을 집합 자료구조이다.
        Set<Pitch> pitchSet = new HashSet<>();
        // 각 자리수에 index로 접근하기 위해 String 으로 변환시켜준다.
        String numStr = String.valueOf(num);

        // 각 자리 index를 돌면서 Pitch를 생성하고, 집합 자료구조에 넣어준다.
        for(int i=0; i<3; i++) {
            pitchSet.add(new Pitch(num + 1, numStr.charAt(i) -'0'));
        }

        return pitchSet;
    }

}
