package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String RESTART = "1";
	private static final String END = "2";

	public String attempt() {
		System.out.print("숫자를 입력해주세요 : ");
		return Console.readLine();
	}

	public String askRestart() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String answer = Console.readLine();

		if (isWrongInput(answer)) {
			throw new IllegalArgumentException("1 또는 2만 입력해주세요.");
		}

		return answer;
	}

	private boolean isWrongInput(String answer) {
		return answer.equals(RESTART) && answer.equals(END) ;
	}
}
