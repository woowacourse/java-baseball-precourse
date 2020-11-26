package baseball.domain;

import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Player {

    public static final Pattern RETRY_PATTERN = Pattern.compile("^1$|^2$");

    public static final String PLAY_AGAIN = "1";

    protected final NumbersGenerator generator;

    protected BaseballNumbers numbers;

    protected final Validator validator;

    public Player(NumbersGenerator generator) {
        this.generator = generator;
        this.validator = new Validator();
    }

    public boolean wantsToPlayAgain(Scanner scanner) {
        String input = scanner.nextLine();
        validator.validateNumbers(RETRY_PATTERN, input);
        return input.equals(PLAY_AGAIN);
    }
}
