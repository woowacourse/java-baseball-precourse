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

	// 플레이어가 입력한 숫자의 유효성을 검증하는 메소드
	public boolean isnotValidNumber(String userinput) {
		if (isnotNumber(userinput)) {
			System.out.println("[ERROR] 숫자만 입력하세요.\n");
			return true;
		} else if (isnotThreeNumber(userinput)) {
			System.out.println("[ERROR] 3자리 숫자가 아닙니다. 3자리 숫자를 입력하세요.\n");
			return true;
		} else if (includeZero(userinput)) {
			System.out.println("[ERROR] 1~9사이의 숫자를 입력하세요.\n");
			return true;
		} else if (duplicateNumber(userinput)) {
			System.out.println("[ERROR] 중복된 숫자가 있습니다. 다시 입력해 주세요.\n");
			return true;
		}
		return false;
	}

	// 입력한 숫자 user배열에 넣어 return
	public int[] makeUserNumber() {

		while (true) {
			System.out.println("(1과 9사이의 서로 다른 세자리 숫자를 입력해 주세요.)");
			System.out.print("Input number> ");
			String userinput = scanner.nextLine();
			if (isnotValidNumber(userinput)) {
				continue;
			} else {
				int[] user = new int[3];
				int usernum = Integer.parseInt(userinput);
				user[0] = usernum / 100;
				user[1] = usernum / 10 % 10;
				user[2] = usernum % 10;
				return user;
			}
		}
	}

	// 컴퓨터의 숫자와 플레이어의 숫자를 비교하여 볼카운트를 하기위한 메소드
	public int[] ballCount(int[] com, int[] user) {

		int[] count = new int[2];
		for (int i = 0; i < 3; i++) {
			if (com[i] == user[i]) {
				count[0] += 1;
			} else if (contains(com, user[i])) {
				count[1] += 1;
			}
		}
		return count;
	}

	// 플레이어에게 hint를 제공하기위한 메소드
	public void showHint(int[] hint) {
		if (hint[0] == 0 && hint[1] == 0) {
			System.out.println("\n[Hint]낫싱");
		} else if (hint[0] == 3) {
			System.out.println("\n축하합니다! 3개의 숫자를 모두 맞히셨습니다.");
		} else {
			System.out.printf("\n[Hint] %d 스트라이크 %d 볼\n\n", hint[0], hint[1]);
		}
	}

}
