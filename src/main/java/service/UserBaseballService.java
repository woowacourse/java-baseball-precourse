package service;

import java.util.Scanner;

import domain.User;
import utils.InputCheckUtils;

public class UserBaseballService {
	private static final Integer MAX_BALL_CNT = 3;
	private static final Integer ZERO = 0;
	private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	private static Integer CURRENT_BALL_CNT = 0;

	public UserBaseballService(Scanner scanner) {
		User user = User.getInstance();

		user.clearNumbers();

		System.out.print(INPUT_MESSAGE);

		String input = scanner.nextLine();

		if (!InputCheckUtils.isVaild(input)) {
			throw new IllegalArgumentException();
		}

		for (CURRENT_BALL_CNT = ZERO; CURRENT_BALL_CNT < MAX_BALL_CNT; CURRENT_BALL_CNT++) {
			int nextNumber = Character.getNumericValue(input.charAt(CURRENT_BALL_CNT));
			user.setNumber(nextNumber);
		}
	}
}
