package baseball;

import baseball.controller.GameController;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Scanner;

/**
 * 프로그램을 실행하는 클래스
 *
 * @author 조연우
 * @version 1.0 2020년 11월 25일
 */
public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        final InputView inputView = new InputView(scanner);
        final OutputView outputView = new OutputView();
        final GameController gameController = new GameController(inputView, outputView);

        gameController.run();
    }
}
