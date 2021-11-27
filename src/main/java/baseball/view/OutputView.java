package baseball.view;

public class OutputView {
    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printMessageWithLine(String message) {
        System.out.println(message);
    }

}
