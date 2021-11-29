package baseball;

import static baseball.constants.GameConfig.*;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {
		Set<Integer> answer = new LinkedHashSet<>();
		while (answer.size() < NUMBER_LENGTH) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			answer.add(randomNumber);
		}

		boolean running = true;

		while (running) {
			System.out.print("숫자를 입력해주세요 : ");
			String input = Console.readLine();

			String pattern = "[1-9]{3}";

			if (!input.matches(pattern)) {
				throw new IllegalArgumentException("세 자리의 숫자를 입력해야 합니다.");
			}

			HashMap<Character, Integer> hashMap = new HashMap<>();
			for (char numChar : input.toCharArray()) {
				hashMap.put(numChar, hashMap.getOrDefault(numChar, 0) + 1);
			}
			for (int num : hashMap.values()) {
				if (num > 1) {
					System.out.println("정답은 서로 다른 세 자리 수입니다.");
					continue;
				}
			}
		}

	}

}
