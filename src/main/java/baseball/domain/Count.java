package baseball.domain;

public final class Count {

    private static final int ZERO = 0;

    private int count;

    public Count() {
        this(ZERO);
    }

    public Count(final int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        count++;
    }

    public boolean isZero() {
        return count == ZERO;
    }

    public boolean equals(final int compare) {
        return count == compare;
    }
}
