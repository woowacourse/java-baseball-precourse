package exception;

/**
 * @author delf
 */
public class DuplicatedElementsException extends IllegalArgumentException {
    @Override
    public String getMessage() {
        return "중복된 숫자가 존재합니다.";
    }
}
