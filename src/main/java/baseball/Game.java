package baseball;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
	private ArrayList<Integer> answer;
	public int strike = 0;
	public int ball = 0;

	public Game() {
		this.answer = new ArrayList<>();
		while (this.answer.size() < 3) {
			int number = Randoms.pickNumberInRange(1, 9);
			if(!this.answer.contains(number)) {
				this.answer.add(number);
			}
		}
		// System.out.println(this.answer);
	}

	public void play() {
		System.out.print("숫자를 입력해주세요 : ");
		String strInput = Console.readLine();
		ArrayList<Integer> input = inputToArrayList(strInput);
		countScore(input);
		printScore();
	}

	private ArrayList<Integer> inputToArrayList(String strInput) {
		checkLength(strInput);
		ArrayList<Integer> listInput = new ArrayList<>();
		int number;
		for (int i = 0; i < 3; i++) {
			try {
				number = Integer.parseInt(strInput.substring(i, i + 1));
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("숫자만 입력하세요.");
			}
			if (!listInput.contains(number) && number > 0) {
				listInput.add(number);
			}
		}
		checkLength(listInput);
		return listInput;
	}

	private void checkLength(String input) {
		if(input.length() != 3) {
			throw new IllegalArgumentException("3자리를 입력하세요.");
		}
	}

	private void checkLength(ArrayList<Integer> list) {
		if(list.size() != 3) {
			throw new IllegalArgumentException("1~9까지의 숫자를 중복되지 않게 입력하세요.");
		}
	}

	private void countScore(ArrayList<Integer> input) {
		this.strike = 0;
		this.ball = 0;
		for(int i = 0; i < 3; i++) {
			if(input.get(i) == this.answer.get(i)) {
				this.strike++;
			} else if(input.contains(this.answer.get(i))) {
				this.ball++;
			}
		}
	}

	private void printScore() {
		if(this.strike == 0 && this.ball == 0) {
			System.out.println("낫싱");
			return;
		}
		if(this.ball > 0) {
			System.out.printf("%d볼 ", this.ball);
		}
		if(this.strike == 0 ) {
			System.out.printf("%n");
			return;
		}
		System.out.printf("%d스트라이크", this.strike);
		System.out.printf("%n");
	}
}
