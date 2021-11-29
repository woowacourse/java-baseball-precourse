package baseball.controller;

import java.util.Arrays;
import java.util.List;

import baseball.domain.Computer;
import baseball.domain.Refree;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {

	public static final String ON_GOING = "1";
	public static final String STOP = "2";
	String status = ON_GOING;

	public void runGame() {
		Computer computer = new Computer();
		// List<Integer> computerNumbers = computer.createRandomNumbers();
		List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
		Refree refree = new Refree();
		String result = "";

		while (!status.equals(STOP)) {
			OutputView.printInputInstruction();
			List<Integer> playerNumbers = refree.askNumbers(InputView.getInput());

			result = refree.compare(computerNumbers, playerNumbers);
			OutputView.printResult(result);

			if (isThreeStrike(result)) {
				OutputView.printRestartInstrunction();
				computerNumbers = computer.createRandomNumbers();
				status = refree.askRestart(InputView.getInput());
			}

		}

	}

	private boolean isThreeStrike(String result) {
		return result.equals("3스크라이크");
	}
}
