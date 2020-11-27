package baseball;

import baseball.domain.BaseballGame;
import baseball.view.InputView;

import java.util.Scanner;

public class Application {
    private static final String END = "2";

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        BaseballGame baseballGame = new BaseballGame();
        do {
            baseballGame.play(scanner);
        } while (!InputView.inputRestartOrEnd(scanner).equals(END));
    }

}
