package service;

import java.util.Scanner;

import domain.User;
import utils.InputCheckUtils;

/**
 * 숫자야구의 유저(사용자)턴
 * 기능 1. 유저의 입력을 검사하고 숫자 리스트에 저장
 */
public class UserBaseballService {
	/** 입력 메시지와 입력값 오류 메시지 문자열 상수 */
	private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String INPUT_ERROR_MESSAGE = "잘못된 입력입니다.";
	
	/** 최대로 생성할 수 있는 숫자 갯수를 한정하는 상수 */
	private static final Integer MAX_BALL_CNT = 3;
	
	/** 초기값을 위한 상수 */
	private static final Integer ZERO = 0;

	/** 현재 생성된 숫자를 카운팅하는 변수 */
	private static Integer CURRENT_BALL_CNT = 0;

	public UserBaseballService(Scanner scanner) {
		initNumbers(scanner);
	}
	
	public void initNumbers(Scanner scanner) {
		/** 객체 불러오기 */
		User user = User.getInstance();

		/** 객체의 숫자 리스트 비우기 */
		user.clearNumbers();

		/** 입력 메시지 출력하고 입력 받기 */
		System.out.print(INPUT_MESSAGE);
		String input = scanner.nextLine();

		/** 올바른 값이 입력되었는지 검사 */
		if (!InputCheckUtils.isVaild(input)) {
			/** 올바르지 않은 값이 입력되었다면 오류메시지와 함께 Exception 발생 */
			throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
		}

		for (CURRENT_BALL_CNT = ZERO; CURRENT_BALL_CNT < MAX_BALL_CNT; CURRENT_BALL_CNT++) {
			/** 문자형의 입력값을 숫자형으로 변환해 숫자 리스트에 삽입 */
			int nextNumber = Character.getNumericValue(input.charAt(CURRENT_BALL_CNT));
			user.setNumber(nextNumber);
		}
	}
}
