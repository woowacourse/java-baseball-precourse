public class InvalidInputException extends IllegalArgumentException {

    InvalidInputException() {
        super();
    }

    InvalidInputException(String errorMessage) {
        super(errorMessage);
    }
}
