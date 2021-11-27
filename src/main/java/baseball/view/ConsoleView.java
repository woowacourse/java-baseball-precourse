package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleView implements View {
	public void print(String msg) {
		System.out.println(msg);
	}

	public String readLine() {
		return Console.readLine();
	}
}
