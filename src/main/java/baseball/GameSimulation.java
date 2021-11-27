package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameSimulation {

	private Integer strike;
	private Integer ball;
	private List<Integer> comNum;
	private List<Integer> userNum;

	public void init() {
		this.comNum = Randoms.pickUniqueNumbersInRange(1, 9, 3);
	}

	public void playGame() {
		String userInput = Console.readLine();
		this.userNum = makeList(userInput);
		System.out.println(userNum);

	}

	public List<Integer> makeList(String userInput) {
		String[] arrayInput = userInput.split("");
		List<Integer> userNumbers = new ArrayList<>();
		for (int i=0; i<userInput.length();i++) {
			userNumbers.add(Integer.parseInt(arrayInput[i]));
		}
		return userNumbers;
	}


}
