package baseball;

import baseball.domain.Computer;
import baseball.domain.Result;
import baseball.domain.Token;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import jdk.internal.util.xml.impl.Input;

public class Application {
    public static void main(String[] args) {
        // //TODO: 숫자 야구 게임 구현
        Computer com = Computer.getInstance();
        com.init();
        boolean flag = true;
        while (flag) {
            Result result = com.matchBalls(InputView.readLine());
            OutputView.print(result.report());
            flag = !result.is3Strike();
        }
        OutputView.print();
        Token.from(InputView.chooseReplay()).isReplay();
    }
}
