package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleView implements View {
	@Override
	public void print(String msg) {
		System.out.println(msg);
	}

	@Override
	public String readLine() {
		return Console.readLine();
	}

	@Override
	public String request(String msg) {
		print(msg);
		return readLine();
	}
}
