package baseball;

public class InvalidInputException extends IllegalArgumentException{

    public InvalidInputException() {
        super();
    }

    public InvalidInputException(int number) {
        super(String.format("유효하지 않은 입력값: %d", number));
    }

    public InvalidInputException(String msg) {
        super(msg);
    }

}
