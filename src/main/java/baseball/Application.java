package baseball;

import baseball.domain.Computer;
import baseball.domain.Result;
import baseball.domain.Token;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 숫자 야구 게임 구현
        Computer com = Computer.getInstance();
        boolean token = true;
        while (token) {
            com.init();
            play(com);
            OutputView.print();
            token = Token.from(InputView.chooseReplay()).isReplay();
        }
    }

    private static void play(Computer com) {
        boolean flag = true;
        while (flag) {
            Result result = com.matchBalls(InputView.readLine());
            OutputView.print(result.report());
            flag = !result.is3Strike();
        }
    }
}
