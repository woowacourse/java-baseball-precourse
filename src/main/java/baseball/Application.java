package baseball;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		// TODO 구현 진행
		Game game = new Game();
		while (!game.isTerminate()) {
			System.out.print("숫자를 입력해주세요 : ");
			game.run(scanner.next());
			if (game.isAnswer()) {
				System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
				game.setStatus(scanner.nextInt());
			}
		}
	}
}
