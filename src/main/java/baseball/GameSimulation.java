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

	private String message;

	public GameSimulation() {
		init();
	}

	public void init() {
		comNum = Randoms.pickUniqueNumbersInRange(1, 9, 3);
	}

	public void playGame() {
		System.out.println("숫자를 입력해주세요 : ");
		String userInput = Console.readLine();
		this.userNum = makeList(userInput);
		System.out.println(userNum);
		validateUserNum();
		compareNumbers();
		System.out.println(compareResultReturn());
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

	public String compareResultReturn() {
		if (ball != 0 && strike != 0) {
			return (ball + "볼" + " " + strike + "스트라이크");
		}
		if (ball == 0 && strike != 0) {
			return (strike + "스트라이크");
		}
		if (ball != 0 && strike == 0) {
			return (ball + "볼");
		}
		return ("낫싱");
	}

	public boolean gameEndCheck() {
		if (strike != null && strike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			System.out.println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");

			String response = Console.readLine();
			if (response.equals("1")) {
				init();
				return true;
			}
			if (response.equals("2")) {
				return false;
			}
			throw new IllegalArgumentException("올바른 숫자가 아닙니다. 1 또는 2를 입력하세요.");
		}
		return true;
	}

}
