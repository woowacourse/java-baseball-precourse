package baseball;

import java.util.Scanner;

public class Application {
    private ConsoleView view;

    Application(ConsoleView consoleView) {
        this.view = consoleView;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Application app = new Application(new ConsoleView(scanner));
        app.run();
    }

    private void run() {
        Baseball baseball = new Baseball(this.view);
        do {
            baseball.start();
        } while (this.view.askWantContinue());
    }

}
