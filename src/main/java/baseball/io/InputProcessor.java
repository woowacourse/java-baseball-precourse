package baseball.io;

import baseball.Results;
import baseball.type.GameStatus;
import camp.nextstep.edu.missionutils.Console;

public class InputProcessor {
	private InputProcessor() { }

	public static String readValue() {
		System.out.print("숫자를 입력해주세요 : ");
		return readLine();
	}

	public static GameStatus readGameStatus() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String input = readLine();
		return getGameStatus(input);
	}

	private static GameStatus getGameStatus(String input) {
		if(input.equals(GameStatus.RESTART.getTag())){
			return GameStatus.RESTART;
		} else if(input.equals(GameStatus.EXIT.getTag())){
			return GameStatus.EXIT;
		}
		throw new IllegalArgumentException("1 또는 2만 입력할 수 있습니다.");
	}

	private static String readLine(){
		return Console.readLine();
	}
}
