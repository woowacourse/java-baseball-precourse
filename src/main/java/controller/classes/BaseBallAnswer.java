package controller.classes;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static model.constants.ConstantsForGame.*;

import java.util.ArrayList;
import java.util.List;

public class BaseBallAnswer {
	private String answer ="";
	private List<Integer> checkingList = new ArrayList<>(MAX_LENGTH_OF_ARRAY);
	private List<Integer> answerArray = new ArrayList<>(3);

	public BaseBallAnswer() {
		initCheckingList();
	}

	public void makeAnswer() {
		answerArray = pickUniqueNumbersInRange(1,9,3);
		refreshAnswer();
	}

	public String getAnswer() {
		return answer;
	}

	private void initCheckingList() {
		for (int i = 0; i < checkingList.size(); i++) {
			checkingList.set(i,0);
		}
	}

	private void refreshAnswer() {
		for (int i = 0; i < answerArray.size(); i++) {
			answer += String.valueOf(answerArray.get(i));
			checkingList.set(answerArray.get(i), 1);
		}
	}
}
