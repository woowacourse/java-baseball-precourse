package baseball.domain;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Player {

    protected final NumbersGenerator generator;

    protected BaseballNumbers numbers;

    protected final Validator validator;

    public Player(NumbersGenerator generator) {
        this.generator = generator;
        this.validator = new Validator();
    }

    public List<Integer> getNumbers() {
        return numbers.getNumbers();
    }

    public boolean wantsToStop(Scanner scanner) {

    }
}
