package baseball.view;

import baseball.constant.Constants;

public class InputView {

    private InputView() {
    }

    public static void setUserNumber() {
        System.out.print(Constants.PLEASE_INPUT_NUMBER);
    }

    public static void setRetryNumber() {
        System.out.println(Constants.PLEASE_INPUT_RETRY_NUMBER);
    }
}
