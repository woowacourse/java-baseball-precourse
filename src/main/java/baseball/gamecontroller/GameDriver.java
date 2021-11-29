package baseball.gamecontroller;

import java.util.HashSet;

import baseball.constantstorage.Constant;
import baseball.errorhandler.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class GameDriver {
	HintGiver hintGiver = new HintGiver();
	String answer = "";

	public void run() {
		do {
			play();
			askResume();
		} while (answer.equals(Constant.RESUME));
	}

	private void play() {
		hintGiver.initHint();
		HashSet<Integer> realAnswer = NumberGenerator.generateNumSet();
		while (!hintGiver.hint.equals(Constant.NUMBER_LENGTH + Constant.STRIKE)) {
			System.out.print(Constant.ASK_ANSWER);
			this.answer = Console.readLine();
			InputValidator.checkPlayerAnswer(this.answer);
			int playerAnswer = Integer.parseInt(this.answer);
			hintGiver.setScore(realAnswer, playerAnswer);
			hintGiver.getHint();
		}
		System.out.println(Constant.YOU_WIN);
	}

	private void askResume() {
		System.out.println(Constant.ASK_RESUME);
		this.answer = Console.readLine();
		InputValidator.checkResumeAnswer(this.answer);
	}
}
