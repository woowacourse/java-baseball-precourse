package baseball.exception;

public class WrongGuessException extends Exception{
    public WrongGuessException() {

    }

    public WrongGuessException(String message) {
        super(message);
    }
}
