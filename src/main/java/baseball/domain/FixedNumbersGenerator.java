package baseball.domain;

import java.util.Scanner;

public class FixedNumbersGenerator implements NumbersGenerator{

    private final Scanner scanner;

    public FixedNumbersGenerator(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String generateNumbers() {
        return scanner.nextLine();
    }
}
