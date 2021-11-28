package baseball.Result;

public abstract class ResultBase {
    protected ResultType resultType;
    protected String message;
    protected ResultBase next;

    protected ResultBase(ResultType resultType, String message) {
        this.resultType = resultType;
        this.message = message;
    }

    public final ResultBase appendNext(ResultBase next) {
        this.next = next;
        return this;
    }

    public abstract String getMessage(int strikeCount, int ballCount, ResultType resultType);
}
