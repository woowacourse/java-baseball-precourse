package baseball.view;

import java.util.Scanner;

public class AppView {
    private Scanner scanner;

    public AppView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputLine() {
        String line = scanner.nextLine();
        return line;
    }

    public void outputMessage(String message) {
        System.out.print(message);
    }
}
