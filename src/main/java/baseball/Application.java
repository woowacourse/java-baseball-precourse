package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
	private static final int RESTART_CODE = 1;

	public static void main(String[] args) {
		//TODO: 숫자 야구 게임 구현
		Scanner scanner = new Scanner(System.in);
		int playingStatus;

		// do {
		// 	ArrayList<Integer> generationNumbers = Number.createRandomNumbers();
		// 	Game.play(scanner, generationNumbers);
		// 	playingStatus = Game.isContinue(scanner);
		// } while (playingStatus == RESTART_CODE);

		scanner.close();
	}
}
