package baseball.Result;

public class NothingResult extends ResultBase {
    public NothingResult() {
        super(
                ResultType.NOTHING,
                "낫싱" + System.lineSeparator()
        );
    }

    @Override
    public final String getMessage(int strikeCount, int ballCount, ResultType resultType) {
        if (this.resultType.equals(resultType)) {
            return message;
        }

        return this.next.getMessage(strikeCount, ballCount, resultType);
    }
}
