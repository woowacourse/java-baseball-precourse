package baseball.domain.exception;

public class InvalidGameResultException extends RuntimeException {
    private static final String ERROR_MESSAGE = "유효하지 않은 볼 및 스트라이크 결과입니다. (볼 : %d, 스트라이크 : %d)";

    public InvalidGameResultException(int ballCounts, int strikeCounts) {
        super(String.format(ERROR_MESSAGE, ballCounts, strikeCounts));
    }
}
