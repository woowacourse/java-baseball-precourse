package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.Computer.*;

public class Player {

	public static String getGuessInput() {
		System.out.print("숫자를 입력해주세요 : ");
		return Console.readLine();
	}

	public static String getRestartInput() {
		System.out.printf("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.\n", RESTART_YES, RESTART_NO);
		return Console.readLine();
	}
}
