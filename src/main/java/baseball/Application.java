package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static class Game {
		public List<Integer> answer;

		Game() {
			startGame();
		}

		private boolean checkIsDuplicated(int num) {
			for (Integer i : answer) {
				if (i == num) {
					return true;
				}
			}
			return false;
		}

		private void startGame() {
			answer = new ArrayList<>();
			for (int i = 0; i < 3; i++) {
				int randomNum = Randoms.pickNumberInRange(1, 9);
				while (checkIsDuplicated(randomNum)) {
					randomNum = Randoms.pickNumberInRange(1, 9);
				}
				answer.add(randomNum);
			}
		}

		private List<Integer> stringToIntList(String str) {
			List<Integer> output = new ArrayList<>();
			for (int i = 0; i < str.length(); i++) {
				int number = str.charAt(i) - '0';
				output.add(number);
			}
			return output;
		}

		private void validateInput(List<Integer> lst) throws IllegalArgumentException {
			if (lst.size() < 3) {
				throw new IllegalArgumentException();
			}
			for (Integer i : lst) {
				if (i < 1 || i > 9) {
					throw new IllegalArgumentException();
				}
			}
		}

		public void getInputFromUser() {
			String inputString = Console.readLine();
			List<Integer> inputNumbers = stringToIntList(inputString);
			try {
				validateInput(inputNumbers);
			} catch (IllegalArgumentException e) {
				System.out.println("Illegal Input");
			}
		}
	}

	public static void main(String[] args) {
	}
}
