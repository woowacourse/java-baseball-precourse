package baseball.pitcher;

import baseball.hitter.Hitter;
import java.util.ArrayList;
import java.util.List;

public class Pitcher {

    List<Integer> pitchingList;

    public Pitcher(String input) {
        assertInputString(input);

        pitchingList = new ArrayList<>(3);
        for (char c : input.toCharArray()) {
            pitchingList.add(charToPitch(c));
        }
    }

    public PitchingResult play(Hitter hitter) {
        assertHitter(hitter);

        PitchingResult result = new PitchingResult();
        for (int i = 0; i < pitchingList.size(); i++) {
            result.add(hitter.hit(i, pitchingList.get(i)));
        }
        return result;
    }

    private void assertHitter(Hitter hitter) {
        if (hitter == null) {
            throw new IllegalArgumentException("hitter 가 null 입니다");
        }
    }

    private Integer charToPitch(char c) {
        int pitch = c - 48;
        assertPitch(pitch);
        return pitch;
    }

    private void assertPitch(int pitch) {
        if (pitch < 0 || 9 < pitch) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다");
        } else if (pitchingList.contains(pitch)) {
            throw new IllegalArgumentException("각각의 숫자는 서로 달라야합니다");
        }
    }

    private void assertInputString(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력값이 null 입니다");
        } else if (input.length() != 3) {
            throw new IllegalArgumentException("3가지 숫자만 입력할 수 있습니다");
        }
    }
}
