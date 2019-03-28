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

}
