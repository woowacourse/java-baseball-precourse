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
        gameStart(com);
    }

    private static void gameStart(Computer com) {
        boolean token = true;
        while (token) {
            com.init();
            play(com);
            OutputView.print();
            token = Token.from(InputView.chooseReplay()).isReplay();
        }
    }

    private static void play(Computer com) {
        boolean is3Strike = false;
        while (!is3Strike) {
            Result result = com.matchBalls(InputView.readLine());
            OutputView.print(result.report());
            is3Strike = result.is3Strike();
        }
    }
}
