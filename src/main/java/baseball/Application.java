package baseball;

import java.util.Scanner;

public class Application {
    private ConsoleView view;

    Application(ConsoleView ConsoleView) {
        this.view = ConsoleView;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Application app = new Application(new ConsoleView(scanner));
        app.run();
    }

    private void run() {
        String inputMessage = this.view.requestNumber();
    }

}
