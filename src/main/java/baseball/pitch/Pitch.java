package baseball.pitch;

public class Pitch {
    private final int index;
    private final int value;

    public Pitch(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public boolean isValid() {
        return !(value == 0);
    }

    @Override
    public boolean equals(Object target) {
        return isSame((Pitch)target);
    }

    @Override
    public int hashCode() {
        return 31 * index * value;
    }

    public boolean isSame(Pitch pitch) {
        return (this.index == pitch.index) && (this.value == pitch.value);
    }

    public boolean isBall(Pitch pitch) {
        // 위치는 다르면서, 값은 같으면 볼이다.
        if(pitch.index != index && pitch.value == value) {
            return true;
        }
        return false;
    }

    public boolean isStrike(Pitch pitch) {
        // 위치와 인덱스가 모두 같으면 스트라이크이다.
        if(pitch.index == index && pitch.value == value) {
            return true;
        }
        return false;
    }

    public boolean isNothing(Pitch pitch) {
        // 값이 다르면 낫싱이다.
        if(pitch.value != value) {
            return true;
        }
        return false;
    }
}
