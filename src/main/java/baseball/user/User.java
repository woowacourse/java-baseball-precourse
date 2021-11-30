package baseball.user;

import static baseball.Constants.*;
import static camp.nextstep.edu.missionutils.Console.*;

import java.util.HashSet;
import java.util.Set;

public class User {
	// 유저가 입력한 숫자
	public int[] input = new int[3];

	// 입력 받아 input에 저장
	public void getInput() {
		// 입력
		System.out.print("숫자를 입력해주세요 : ");
		String inputs = readLine();
		// 3자리수가 아니면 오류 발생
		checkLen(inputs);
		// 숫자 변환
		int Num = toInt(inputs);
		// 숫자를 배열로 변환
		input = toArray(Num);
		// 중복 값 오류 발생
		isSame(input);

	}

	// 3자리수 인지 확인하는 메소드
	private void checkLen(String inputs) {
		if (inputs.length() != maxNumberLen) {
			throw new IllegalArgumentException(maxNumberLen + "자리 수를 입력하세요");
		}
	}

	// 입력값 내에 중복값이 있으면 오류 발생
	private void isSame(int[] array) {
		Set<Integer> set = new HashSet<>();
		// 타켓 넘버들을 set에 넣는다
		for (int number : array) {
			set.add(number);
		}
		if (set.size() != array.length) {
			throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다");
		}
	}

	// 문자열을 숫자로 바꾸는 함수
	private int toInt(String inputs) {
		int Num;

		try {
			// 문자열을 숫자로 바꿔준다
			Num = Integer.parseInt(inputs);
			return Num;
		} catch (Exception e) {
			// 숫자가 아닌 값이 들어있으면 오류 반환
			// ArgumentException오류가 뜨지 않으므로 ArgumentException이 뜨도록 만들어준다
			throw new IllegalArgumentException("숫자를 입력하세요");
		}

	}

	// 3자리 수를 배열로 만드는 함수
	private int[] toArray(int Num) {
		int[] intArray = new int[maxNumberLen];
		int n;
		
		// 3자리 수를 10으로 나누면서 그 나머지를 배열의 뒤에서부터 할당
		for (int i = maxNumberLen - 1; i >= 0; i--) {
			n = Num % 10;
			//입력된 숫자가 0이면 오류 반환
			if (n == 0) {
				throw new IllegalArgumentException("1~9사이의 숫자를 입력하시오");
			}
			intArray[i] = n;
			Num /= 10;
		}
		return intArray;
	}

}
