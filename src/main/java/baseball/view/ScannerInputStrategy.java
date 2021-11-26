package baseball.view;

import java.util.Scanner;

import static java.lang.System.out;

public class ScannerInputStrategy implements InputStrategy {

    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String getInput() {
        out.print(INPUT_NUMBER);
        return scanner.nextLine();
    }
}
