package Baseball;

public class Result {
    private int strikes;
    private int B;
    public Result(int strikes, int B) {
        this.strikes = strikes;
        this.B = B;
    }

    @Override
    public boolean equals(Object object) {
        if ((object == null) || object.getClass() != this.getClass()) {
            return false;
        }

        return this.strikes == ((Result)object).strikes && this.B == ((Result)object).B;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getB() {
        return B;
    }
}
