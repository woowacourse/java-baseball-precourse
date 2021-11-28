package baseball.Result;

public abstract class ResultBase {
    protected String message;
    protected ResultBase next;

    protected ResultBase(String message) {
        this.message = message;
    }

    public final ResultBase appendNext(ResultBase next) {
        this.next = next;
        return this.next;
    }

    public abstract String getMessage(int strikeCount, int ballCount);
}
