package baseball.controller;

import java.util.List;

import baseball.domain.Computer;
import baseball.view.InputView;

public class Controller {
	public void runGame() {
		Computer computer = new Computer();
		List<Integer> computerNumbers = computer.createRandomNumbers();
		System.out.println(computerNumbers);
		// while (true) {
		// 	String input = InputView.getInput();
		// }
	}
}
