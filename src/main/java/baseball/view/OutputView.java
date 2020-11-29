package baseball.view;

public class OutputView {

    private OutputView() {
    }

    public static void showError(String error) {
        System.out.println(error);
    }

    public static void showResult(String result) {
        System.out.println(result);
    }
}
