package baseball;

import baseball.domain.BallStrikeCount;
import baseball.domain.Number;
import baseball.domain.UniqueNumberFactory;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameRunner {

    private final InputView inputView;
    private final OutputView outputView;
    private Computer computer;

    public GameRunner(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {

        do {
            newGame();
            playGame();
            exitGame();
        } while (wantNewGame());

    }

    private boolean wantNewGame() {
        return inputView.wantNewGame();
    }

    private void exitGame() {
        outputView.exitGame();
    }

    private void newGame() {
        // Computer 클래스가 꼭 필요할까?
        // Computer 없이 그냥 Number 타입을 여러개 쓰니까
        // Number 타입이 여러개라서 헷갈린다.
        // Number를 상속해서 PlayerNumber, ComputerNumber 처럼 여러 클래스를 만들까?
        // Computer가 하는 일이 전혀 없지는 않을 것 같기도?
        Number computerNumber = UniqueNumberFactory.create();
        computer = new Computer(computerNumber);
    }

    private void playGame() {
        while (true) {
            Number playerNumber = inputView.guessNumber();
            BallStrikeCount result = computer.countBallStrike(playerNumber);
            outputView.printResult(result);
            if (result.isThreeStrike()) {
                return;
            }
        }
    }

}
