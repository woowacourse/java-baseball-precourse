package baseball.view;

public class OutputView {
    private static final OutputView INSTANCE = new OutputView();

    public static OutputView getInstance() {
        return INSTANCE;
    }

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printMessageWithLine(String message) {
        System.out.println(message);
    }

}
