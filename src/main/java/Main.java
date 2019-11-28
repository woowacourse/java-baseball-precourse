import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		init();
	}

	private static void init() {

		while (true) {
			String computerInput = randomize();

			startGame(computerInput);

			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

			int command = sc.nextInt();
			if (command == 1) {
				continue;
			} else if (command == 2) {
				break;
			} else {

			}
		}
	}

	private static String randomize() {
		String number = "";
		boolean[] check = new boolean[10];
		Random generator = new Random();
		for (int i = 0; i < 3; i++) {
			int randomNumber = generator.nextInt(9) + 1;
			if (check[randomNumber]) {
				i--;
			} else {
				check[randomNumber] = true;
				number += randomNumber;
			}
		}
		System.out.println(number);
		return number;
	}

	private static void startGame(String computerInput) {
		while (true) {
			System.out.print("숫자를 입력해주세요: ");
			String userInput = sc.nextLine();
			
			
		}

	}

	

}
