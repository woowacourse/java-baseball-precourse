package baseball.controller;

import java.util.List;

import baseball.domain.Computer;
import baseball.domain.Refree;
import baseball.view.InputView;

public class Controller {

	public static final String ON_GOING = "1";
	public static final String STOP = "2";
	String status = ON_GOING;

	public void runGame() {
		Computer computer = new Computer();
		List<Integer> computerNumbers = computer.createRandomNumbers();
		while (!status.equals(STOP)) {
			Refree refree = new Refree();
			List<Integer> playerNumbers = refree.askNumbers(InputView.getInput());
			System.out.println(playerNumbers);
		}

	}
}
