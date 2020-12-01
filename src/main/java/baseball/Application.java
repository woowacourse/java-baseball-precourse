package baseball;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		// TODO 구현 진행
		Game game = new Game();
		boolean finish = true;

		while (finish) {
			System.out.println("게임을 새로 시작하려면 1번, 종료하려면 2번를 입력하세요.");
			int selectGame = scanner.nextInt();

			switch (selectGame) {
			case 1:
				System.out.println("게임을 시작 합니다.");
				game.start();
				break;
			case 2:
				System.out.println("게임을 종료 합니다.");
				finish = false;
				break;
			default:
				System.out.println("잘못 입력 하셨습니다.");
				break;
			}
		}
	}
}
