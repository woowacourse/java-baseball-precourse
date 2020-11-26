package baseball.domain;

import java.util.Scanner;

public class FixedNumbersGenerator implements NumbersGenerator {

    public static final String ASK_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";

    private final Scanner scanner;

    public FixedNumbersGenerator(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String generateNumbers() {
        System.out.println(ASK_NUMBERS_MESSAGE);
        return scanner.nextLine();
    }
}
