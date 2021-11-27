package baseball;

import baseball.domain.Computer;
import baseball.domain.Result;
import baseball.domain.Token;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 숫자 야구 게임 구현
        Computer computer = Computer.getInstance();
        gameStart(computer);
    }

    private static void gameStart(Computer computer) {
        boolean token = true;
        while (token) {
            computer.init();
            play(computer);
            OutputView.print();
            token = Token.from(InputView.chooseReplay()).isReplay();
        }
    }

    private static void play(Computer computer) {
        boolean is3Strike = false;
        while (!is3Strike) {
            Result result = computer.matchBalls(InputView.readLine());
            OutputView.print(result.report());
            is3Strike = result.is3Strike();
        }
    }
}
