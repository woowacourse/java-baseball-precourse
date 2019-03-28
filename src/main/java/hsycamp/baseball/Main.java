package hsycamp.baseball;

import java.util.Scanner;

public class Main {

	Scanner scanner = new Scanner(System.in);
	Baseball bsb = new Baseball();

	public void runPrompt() {

		int[] com = bsb.makeComNumber();
		int[] user = new int[3];
		int[] hint = new int[2];

		System.out.println("[[게임 시작]]\nComputer number:[ ? , ? , ? ]\n");

		while (true) {
			user = bsb.makeUserNumber();
			hint = bsb.ballCount(com, user);
			bsb.showHint(hint);
			if (hint[0] == 3) {
				break;
			}
		}
		replay();
		scanner.close();
	}

	public void replay() {

		while (true) {
			System.out.println("\n게임을 새로 시작하시려면 1 , 종료하려면 2 를 입력하세요.");
			System.out.print("Input> ");
			String end = scanner.nextLine();
			if (bsb.isnotNumber(end)) {
				System.out.println("[ERROR] 숫자만 입력하세요.\n");
				System.out.print("Input> ");
				continue;
			} else if (Integer.parseInt(end) == 1) {
				runPrompt();
			} else if (Integer.parseInt(end) == 2) {
				System.out.println("[[게임 종료]]");
				System.exit(0);
			} else {
				System.out.println("[ERROR] 1과 2중에서 선택하세요.");
				System.out.print("Input> ");
			}
		}
	}

	public static void main(String[] args) {
		// 셀 실행
		Main b = new Main();
		b.runPrompt();
	}

}
