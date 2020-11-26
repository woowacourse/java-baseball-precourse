package baseball;

import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getValidInput(Request reqType) {
        String input = scanner.next();
        if (reqType == Request.THREENUMS)
            return threeNumValidCheck(input);
        if (reqType == Request.RESTART)
            return restartValidCheck(input);
        return input;
    }

    private String threeNumValidCheck(String input) {
        if (input.length() != 3)
            throw new IllegalArgumentException();
        return input;
    }

    private String restartValidCheck(String input) {
        if (!input.equals("1")  && !input.equals("2"))
            throw new IllegalArgumentException();
        return input;
    }

}
