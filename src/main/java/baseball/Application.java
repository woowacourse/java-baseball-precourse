package baseball;

import java.util.ArrayList;
import java.util.List;

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
	}

	public static void main(String[] args) {
	}
}
