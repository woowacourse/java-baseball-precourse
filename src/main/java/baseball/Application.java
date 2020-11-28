package baseball;

import java.util.Scanner;
import utils.RandomUtils;

public class Application {
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		// TODO 구현 진행
		String[] randomNumbers = new String[3];

		for (int i = 0; i < 3; i++) {
			int random = RandomUtils.nextInt(1, 9);
			randomNumbers[i] = String.valueOf(random);
		}
		for (int i = 0; i < 3; i++) {
		System.out.println(randomNumbers[i]);
		}
	}
}
