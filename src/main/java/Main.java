import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		init();
	}

	private static void init() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String randomNumber = randomize();
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
		return number;
	}

}
