package baseball;

import java.util.Arrays;

public class Game {
	private String computerNumber;

	/**
	 * 서로 다른 임의의 숫자(1부터 9 사이) 3개를 생성하는 메서드
	 */
	public void setComputerNumber() {
		int current = 3;
		int[] computer = new int[3];
		while (current > 0) {
			int selected = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1, 9);

			// 중복된 값이 없다면 해당 숫자 추가
			if (!Arrays.asList(computer).contains(selected)) {
				computer[3 - current] = selected;
				current--;
			}
		}
		computerNumber = Arrays.toString(computer).replaceAll("[^0-9]", "");
	}

	/**
	 * 컴퓨터가 입력한 수와 사용자가 입력한 수를 비교해서 볼, 스트라이크의 개수를 카운트하는 메서드
	 * @param inputNumber
	 * @return int[]
	 */
	public int[] compareNumber(String inputNumber) {
		// TODO: 컴퓨터가 입력한 수와 사용자가 입력한 수를 비교해서 볼, 스트라이크의 개수를 카운트하는 메서드
		int[] result = {0, 0};

		for (int i = 0; i < 3; i++) {
			if (computerNumber.charAt(i) == inputNumber.charAt(i)) {
				result[1]++;
			} else if (inputNumber.indexOf(computerNumber.charAt(i)) != -1) {
				result[0]++;
			}
		}
		return result;
	}

	/**
	 * 카운트한 결과를 출력하는 메서드
	 * @param result
	 */
	public void printResult(int[] result) {
		if (result[0] == 0 && result[1] == 0) {
			System.out.println("낫싱");
		} else if (result[0] == 0) {
			System.out.println(result[1] + "스트라이크");
		} else if (result[1] == 0) {
			System.out.println(result[0] + "볼");
		} else {
			System.out.println(result[0] + "볼 " + result[1] + "스트라이크");
		}
	}

	/**
	 * 정답을 맞췄을 때 게임 종료여부를 묻는 입력을 받는 메서드
	 * @return int
	 */
	public int askToRestart() {
		// TODO: 정답을 맞췄을 때 게임 종료여부를 묻는 입력을 받는 기능
		return 2;
	}

	/**
	 * 게임을 시작해서 스트라이크3이 나올때까지 계속 입력을 받는 기능
	 * @return int
	 */
	public int startGame() {
		while (true) {
			System.out.println("숫자를 입력해주세요 : ");
			String inputNumber = camp.nextstep.edu.missionutils.Console.readLine();
			InputChecker.checkStringIsThreeNumbers(inputNumber);
			int[] result = compareNumber(inputNumber);
			printResult(result);

			if (result[1] == 3) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
					+ "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
				return askToRestart();
			}
		}
	}

}
