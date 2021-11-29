package baseball.player;

import camp.nextstep.edu.missionutils.Console;

public class Player {

	public String readUserAnswer() {
		System.out.println("숫자를 입력해주세요 :");
		//TODO 유저의 답 유효성 검사할 수 있도록
		return Console.readLine();
	}
}
