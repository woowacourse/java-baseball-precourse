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

    public boolean isSame(Pitch pitch) {
        return (this.index == pitch.index) && (this.value == pitch.value);
    }
}
