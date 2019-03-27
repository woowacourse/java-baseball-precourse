package baseball.util;

import baseball.view.InputView;
import baseball.view.OutputView;
import com.sun.tools.internal.ws.wsdl.document.Output;

import java.util.List;

import static baseball.BaseballNumber.checkValidNumber;

public class InputUtil {

    private InputUtil() {};

    public static List<Integer> getUserNumber() {
        String userNumber = InputView.getNumber();
        while (!checkValidNumber(userNumber)) {
            userNumber = InputView.getNumber();
        }
        return StringParseUtil.parseToInteger(userNumber);
    }
}
