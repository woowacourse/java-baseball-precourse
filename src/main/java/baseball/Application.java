package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static class Game {
		private List<Integer> answer;

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

		private List<Integer> getInputFromUser() {
			String inputString = Console.readLine();
			return stringToIntList(inputString);
		}

		private int compareNumberWithAnswer(int num, int pos) {
			if (answer.get(pos).equals(num)) {
				return 1;
			}
			for (int i = 0; i < 3; i++) {
				if (answer.get(i).equals(num)) {
					return 0;
				}
			}
			return -1;
		}

		private int[] getNumOfStrikesAndBalls(List<Integer> inputNumbers) {
			int[] output = new int[] {0, 0};
			for (int i = 0; i < 3; i++) {
				int res = compareNumberWithAnswer(inputNumbers.get(i), i);
				if (res > -1) {
					output[res] += 1;
				}
			}
			return output;
		}

		public void playGame() {
			List<Integer> userInput = getInputFromUser();
			try {
				validateInput(userInput);
			} catch (IllegalArgumentException e) {
				System.out.println("Illegal Input");
			}
			int[] scoreBoard = getNumOfStrikesAndBalls(userInput);
		}
	}

	public static void main(String[] args) {
	}
}
