package exception;

/**
 * @author delf
 */
public class NotMatchedNumbersSize extends IllegalArgumentException {
    @Override
    public String getMessage() {
        return "숫자가 너무 많거나 적습니다.";
    }
}
