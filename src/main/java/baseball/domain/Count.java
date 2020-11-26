package baseball.domain;

public class Count {

    private int count;

    public Count() {
        this(0);
    }

    public Count(int count) {
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
}
