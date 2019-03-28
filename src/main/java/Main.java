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
		scanner.close();
	}

	public static void main(String[] args) {
		// 셀 실행
		Main b = new Main();
		b.runPrompt();
	}

}
