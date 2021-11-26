package baseball.view;

import java.util.Scanner;

public class ScannerInputStrategy implements InputStrategy {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String getInput() {
        return scanner.nextLine();
    }
}
