package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static class Game {
		private List<Integer> answer;
		private boolean isOver;

		Game() {
			startGame();
			isOver = false;
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
			int[] output = new int[] {0, 0}; // 1은 strike 수, 0은 ball 수
			for (int i = 0; i < 3; i++) {
				int res = compareNumberWithAnswer(inputNumbers.get(i), i);
				if (res > -1) {
					output[res] += 1;
				}
			}
			return output;
		}

		private void judge(int[] scoreBoard) {
			/* 1은 strike 수, 0은 ball 수 */
			if (scoreBoard[1] == 3) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				isOver = true;
			} else if (scoreBoard[0] == 0 && scoreBoard[1] == 0) {
				System.out.println("낫싱");
			} else {
				String ballMsg = "";
				String strikeMsg = "";
				if (scoreBoard[0] > 0) {
					ballMsg += String.format("%d볼", scoreBoard[0]);
				}
				if (scoreBoard[1] > 0) {
					strikeMsg += String.format("%d스트라이크", scoreBoard[1]);
				}
				if (!ballMsg.equals("")) {
					ballMsg += " ";
				}
				System.out.println(ballMsg + strikeMsg);
			}
		}

		public void playGame() {
			List<Integer> userInput = getInputFromUser();
			try {
				validateInput(userInput);
			} catch (IllegalArgumentException e) {
				System.out.println("Illegal Input");
			}
			int[] scoreBoard = getNumOfStrikesAndBalls(userInput);
			judge(scoreBoard);
		}
	}

	public static void main(String[] args) {
	}
}
