package baseball;

import camp.nextstep.edu.missionutils.Console;

public class AfterGameReply {

	int response;

	public boolean askAfterGameReply() {
		try {
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			response = Integer.parseInt(Console.readLine());
		} catch (NumberFormatException numberFormatException) {
			throw new IllegalArgumentException();
		}
		if (response == 1) {
			return true;
		}
		if (response == 2) {
			return false;
		}
		throw new IllegalArgumentException();
	}
}
