package view;

public class OutputView {
    private OutputView() {
    }

    public static void printMessage(String message) {
        System.out.print(message);
    }

    public static void printMessageAndNewLine(String message) {
        System.out.println(message);
    }
}
