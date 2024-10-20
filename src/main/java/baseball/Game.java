package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
	private Computer computer;
	private final Player player = new Player();
	private final Judge judge = new Judge();

	public void start() {
		boolean isPlaying = true;

		while (isPlaying) {
			computer = new Computer();
			boolean isSolved = false;

			while (!isSolved) {
				String input = player.getInput();
				String result = judge.calculateResult(input, computer.getNumbers());
				System.out.println(result);

				if ("3스트라이크".equals(result)) {
					System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
					isSolved = true;
				}
			}

			isPlaying = restart();
		}
	}

	private boolean restart() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String input = Console.readLine();
		if ("1".equals(input)) {
			return true;
		} else if ("2".equals(input)) {
			return false;
		} else {
			throw new IllegalArgumentException("잘못된 입력입니다. 1 또는 2를 입력하세요.");
		}
	}
}
