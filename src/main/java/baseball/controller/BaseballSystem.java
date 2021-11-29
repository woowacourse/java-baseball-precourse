package baseball.controller;

import baseball.model.ComputerNumGenerator;
import baseball.model.Constant;
import baseball.model.UserNumGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballSystem {
	public void runGame() {
		do {
			startOneGameSet();
		} while (!exit());
	}

	private static void startOneGameSet() {
		int[] computerNums = new ComputerNumGenerator().NUMS;
		boolean gameClear;
		do {
			BaseballSet set = new BaseballSet(new UserNumGenerator().NUMS, computerNums);
			new OutputView(set).printGameResult();
			gameClear = set.isMaxStrike();
		} while (!gameClear);
		OutputView.printGameClear();
	}

	private static boolean exit() throws IllegalArgumentException {
		String exitNum = InputView.endInput();
		if (exitNum.equals(Constant.RESTART)) {
			return false;
		}
		if (exitNum.equals(Constant.QUIT)) {
			return true;
		}
		throw new IllegalArgumentException();
	}
}
