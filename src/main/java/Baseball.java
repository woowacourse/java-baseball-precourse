import java.util.Random;
import java.util.Scanner;

public class Baseball {
	Scanner scanner = new Scanner(System.in);

	// 컴퓨터 숫자 생성시 중복 방지를 위한 메소드
	public boolean contains(int[] arr, int item) {
		for (int n : arr) {
			if (item == n) {
				return true;
			}
		}
		return false;
	}

	// 컴퓨터가 서로 다른 3자리 숫자 램덤추출하여 길이 3 짜리 배열에 넣는 메소드
	public int[] makeComNumber() {
		int[] comnums = new int[3];
		Random random = new Random();
		for (int i = 0; i < 3; i++) {
			int a = random.nextInt(9) + 1;
			if (contains(comnums, a)) {
				i -= 1;
			} else {
				comnums[i] = a;
			}
		}
		return comnums;
	}

	// 숫자인지 체크하는 메소드
	public boolean isnotNumber(String userinput) {
		try {
			Integer.parseInt(userinput);
			return false;
		} catch (NumberFormatException e) {
			return true;
		}
	}

	// 3자리 수인지 체크하는 메소드
	public boolean isnotThreeNumber(String userinput) {
		if (userinput.length() != 3) {
			return true;
		} else
			return false;
	}

	// 입력한 숫자중에 0이 있는지 체크하는 메소드
	public boolean includeZero(String userinput) {
		for (int i = 0; i < 3; i++) {
			if (userinput.charAt(i) - '0' == 0) {
				return true;
			}
		}
		return false;
	}

	// 입력한 숫자중에 중복된 숫자가 있는지 체크하는 메소드
	public boolean duplicateNumber(String userinput) {
		if (userinput.charAt(0) == userinput.charAt(1)) {
			return true;
		} else if (userinput.charAt(1) == userinput.charAt(2)) {
			return true;
		} else if (userinput.charAt(2) == userinput.charAt(0)) {
			return true;
		}
		return false;
	}

}
