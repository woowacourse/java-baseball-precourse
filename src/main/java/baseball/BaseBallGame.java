package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class BaseBallGame {
	private final int GAME_NUMBER_LENGTH = 3;
	private LinkedHashSet<Integer> answerNumberSet;
	private ArrayList<Integer> inputNumberArrayList;
	private int ball;
	private int strike;

	public BaseBallGame() {
		answerNumberSet = new LinkedHashSet<>();
		inputNumberArrayList = new ArrayList<>();
	}

	public void start() {
		while (true) {
			makeAnswerNumber();
			play();
			if (isFinishedGame()) {
				break;
			}
		}
	}

	private void play() {
		while (true) {
			initializeRound();
			makeInputNumber();
			calculateScore();
			printScore();
			if (isAnswer()) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				return;
			}
		}
	}

	private void initializeRound() {
		inputNumberArrayList.clear();
		ball = 0;
		strike = 0;
	}

	private void makeInputNumber() {
		String inputNumberString = getInputNumberByConsole();
		if (!isValidInputNumber(inputNumberString)) {
			throw new IllegalArgumentException();
		}
		inputNumberArrayList = getIntegerArrayListFromString(inputNumberString);
	}

	private void makeAnswerNumber() {
		answerNumberSet.clear();
		while (answerNumberSet.size() < GAME_NUMBER_LENGTH) {
			int randomNum = Randoms.pickNumberInRange(1, 9);
			answerNumberSet.add(randomNum);
		}
	}

	private boolean isValidInputNumber(String str) {
		if (str.length() != GAME_NUMBER_LENGTH) {
			return false;
		}
		if (str.contains("0")) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}

		Set<Character> s = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			s.add(str.charAt(i));
		}
		if (s.size() != GAME_NUMBER_LENGTH) {
			return false;
		}

		return true;
	}

	private String getInputNumberByConsole() {
		System.out.print("숫자를 입력해주세요 : ");
		String input = Console.readLine();
		return input;
	}

	private ArrayList<Integer> getIntegerArrayListFromString(String str) {
		ArrayList<Integer> tmp = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			int num = Character.getNumericValue(str.charAt(i));
			tmp.add(num);
		}
		return tmp;
	}

	private void calculateScore() {
		int i = 0;
		for (Integer num : answerNumberSet) {
			if (num.equals(inputNumberArrayList.get(i))) {
				strike++;
				i++;
				continue;
			}
			if (answerNumberSet.contains(inputNumberArrayList.get(i))) {
				ball++;
			}
			i++;
		}
	}

	private boolean isAnswer() {
		int i = 0;
		for (Integer num : answerNumberSet) {
			if (!num.equals(inputNumberArrayList.get(i))) {
				return false;
			}
			i++;
		}
		return true;
	}

	private void printScore() {
		if (ball == 0 && strike == 0) {
			System.out.println("낫싱");
			return;
		}
		if (ball > 0 && strike > 0) {
			System.out.println(ball + "볼 " + strike + "스트라이크");
			return;
		}
		if (ball > 0) {
			System.out.println(ball + "볼");
			return;
		}
		if (strike > 0) {
			System.out.println(strike + "스트라이크");
		}
	}

	private boolean isFinishedGame() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String str = Console.readLine();
		if (str.equals("2")) {
			return true;
		}
		return false;
	}
}