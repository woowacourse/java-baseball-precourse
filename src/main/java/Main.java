import java.util.Scanner;

public class Main {
	Scanner scanner = new Scanner(System.in);
	Baseball bsb = new Baseball();

	public void runPrompt() {

		int[] com = bsb.makeComNumber();

		System.out.println("[[게임 시작]]\nComputer number:[ ? , ? , ? ]\n");

		scanner.close();
	}

	public static void main(String[] args) {
		// 셀 실행
		Main b = new Main();
		b.runPrompt();
	}

}
