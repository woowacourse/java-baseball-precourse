package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {
		//TODO: 숫자 야구 게임 구현
	}

	public String createRandomNumber() {
		String randomNumber = "";
		while (randomNumber.length() < 3) {
			String num = String.valueOf(Randoms.pickNumberInRange(1, 10));
			if (!randomNumber.contains(num)) {
				randomNumber += num;
			}
		}
		return randomNumber;
	}
}
