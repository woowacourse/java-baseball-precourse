package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;

public class GameReply {

	List<Integer> gameReply;

	public GameReply() {
		System.out.print("숫자를 입력해주세요 : ");
		String input = Console.readLine();
	}


}
