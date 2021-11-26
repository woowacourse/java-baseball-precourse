package baseball;

import java.util.ArrayList;
import java.util.List;

public class Hint {
	private int ball = 0;
	private int strike = 0;

	public Hint(List<Integer> answerNumber, List<Integer> inputNumber) {
		for (int i = 0; i < inputNumber.size(); i++) {
			countStrikeOrBall(answerNumber, i, inputNumber.get(i));
		}
	}

	public String getHintMessage() {
		List<String> sList = new ArrayList<>();

		if (this.ball == 0 && this.strike == 0)
			return Const.NOTHING;

		if (this.ball != 0)
			sList.add(ball + Const.BALL);

		if (this.strike != 0)
			sList.add(strike + Const.STRIKE);

		return String.join(" ", sList);
	}

	public boolean isAllStrike() {
		if(this.strike == Const.ANSWER_SIZE){
			System.out.println(Const.GAME_CLEAR_MESSAGE);
			return true;
		}

		return false;
	}

	private boolean isBall(List<Integer> answerNumber, int index, int num) {
		for (int i = 0; i < answerNumber.size(); i++) {
			if (answerNumber.get(i) == num && i != index)
				return true;
		}

		return false;
	}

	private boolean isStrike(List<Integer> answerNumber, int index, int num) {
		for (int i = 0; i < answerNumber.size(); i++) {
			if (answerNumber.get(i) == num && i == index)
				return true;
		}

		return false;
	}

	private void countStrikeOrBall(List<Integer> answerNumber, int index, int num) {
		if (isStrike(answerNumber, index, num)) {
			this.strike += 1;
			return;
		}

		if (isBall(answerNumber, index, num))
			this.ball += 1;
	}
}
