package service;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import constants.Constants;
import dto.CompareResult;

public class UserInterface {
	private Computer computer;
	private Converter converter;

	public UserInterface() {
		computer = new Computer();
		converter = new Converter();
	}

	public void startUserInterface() {
		int resume = Constants.RESUME;
		do {
			// 사용자로 부터 문자열 받기
			String givenString = readLineFromUser();

			// 숫자 리스트로 변환
			List<Integer> givenNumbers = converter.convertStringToIntegerList(givenString);

			// 비교 값 반환
			CompareResult result = computer.compareNumbers(givenNumbers);
			System.out.println(converter.convertResultToString(result));

			// 다 맞추었으면 게임 재시작 여부 물어봄
			if(checkAllCorrect(result)) {
				notifyCorrectAll();
				resume = getResumeIntention();
				checkResume(resume);
			}

		} while(resume == Constants.RESUME);
	}

	private String readLineFromUser() {
		System.out.print("숫자를 입력해주세요 : ");
		return Console.readLine();
	}

	private boolean checkAllCorrect(CompareResult result) {
		if(result.getStrike() != Constants.RANDOM_NUMBER_SIZE) {
			return false;
		}

		return true;
	}
	private void notifyCorrectAll() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	private int getResumeIntention() {
		String restart = Console.readLine();
		return converter.convertStringToInt(restart);
	}

	private void checkResume(int resume) {
		if(resume == Constants.RESUME) {
			computer.refresh();
		}
	}
}
