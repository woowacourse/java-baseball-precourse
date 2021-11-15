package baseball;

import java.util.Scanner;
import utils.RandomUtils;

public class Application {
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		int answer = RandomUtils.nextInt(100, 1000);
		boolean isFinish = false;
		String input;

		while (isFinish == false) {
			System.out.println("숫자를 입력해주세요 : ");
			input = scanner.nextLine();
			System.out.println(input);

		}

	}
}
