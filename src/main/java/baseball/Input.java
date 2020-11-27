package baseball;

import java.util.Scanner;

public class Input {
    private static final String ABNORMAL_INPUT = "비정상적인 입력입니다.";
    private static final int NUMBER_INPUT_LENGTH = 3;
    private static final int INITIAL_NUMBER = 0;
    private Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    private void validateLength(int input, int length) {
        if (getNumberInputLength(input) != length) {
            throw new IllegalArgumentException();
        }
    }

    private int getNumberInputLength(int input) {
        return (int) (Math.log10(input) + 1);
    }

}
