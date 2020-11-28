package baseball.domain;

public final class Count {

    private int count;

    public Count() {
        this(0);
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
        return count == 0;
    }

    public boolean equals(final int compare) {
        return count == compare;
    }
}
