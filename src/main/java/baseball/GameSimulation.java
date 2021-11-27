package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
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
		init();
		System.out.println(comNum);
		System.out.println("숫자를 입력해주세요 : ");
		String userInput = Console.readLine();
		this.userNum = makeList(userInput);
		System.out.println(userNum);
		validateUserNum();
		compareNumbers();
		System.out.println(strike);
		System.out.println(ball);

	}

	public List<Integer> makeList(String userInput) {
		String[] arrayInput = userInput.split("");
		List<Integer> userNumbers = new ArrayList<>();
		for (int i = 0; i < userInput.length(); i++) {
			userNumbers.add(Integer.parseInt(arrayInput[i]));
		}
		return userNumbers;
	}

	public void validateUserNum() {
		if (userNum.size() != 3) {
			throw new IllegalArgumentException("올바른 숫자가 아닙니다. 세자리 숫자를 입력해주세요.");
		}
		if (userNum.contains(0)) {
			throw new IllegalArgumentException("올바른 숫자가 아닙니다. 0을 제외한 숫자를 입력해주세요.");
		}
		for (int i = 0; i < userNum.size(); i++) {
			if (Collections.frequency(userNum, userNum.get(i)) != 1) {
				throw new IllegalArgumentException("올바른 숫자가 아닙니다. 서로 다른 숫자로 이루어져야 합니다.");
			}
		}
	}

	public void compareNumbers() {
		this.strike = 0;
		this.ball = 0;
		for (int i = 0; i < userNum.size(); i++) {
			if (comNum.indexOf(userNum.get(i)) == i) {
				strike++;
				continue;
			}
			if (comNum.contains(userNum.get(i))) {
				ball++;
			}
		}
	}

}
