package exception;

/**
 * @author delf
 */
public class NotDigitException extends IllegalArgumentException {
    @Override
    public String getMessage() {
        return "숫자가 아닙니다.";
    }
}
