package baseball.service.ui;

import baseball.domain.GameType;
import utils.InputConverter;
import utils.validator.DuplicateValidator;
import utils.validator.NumberValidator;
import utils.validator.RestartValidator;
import utils.validator.Validator;

import java.util.Scanner;

public class Input {
    private final Scanner scanner;
    private Validator validator;
    private InputConverter inputConverter;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public int[] inputNumber(){
        String input = scanner.next();

        validate(input);

        return inputConverter.stringToArray(input);
    }

    private void validate(String input) {
        validator = new NumberValidator();
        validator.execute(input);

        validator = new DuplicateValidator();
        validator.execute(input);
    }

    public boolean askRestart() {
        String input = scanner.next();

        validator = new RestartValidator();
        validator.execute(input);

        if (GameType.START.equals(input)) {
            return true;
        }
        return false;
    }


}
