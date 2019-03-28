package exception;

/**
 * @author delf
 */
public class OutOfNumberBoundaryException extends IllegalArgumentException {
    @Override
    public String getMessage() {
        return "범위 외의 숫자입니다.";
    }
}
