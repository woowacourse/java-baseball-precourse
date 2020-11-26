package service;

import domain.Computer;
import utils.RandomUtils;

public class ComputerBaseballService {
	private static final Integer MAX_BALL_CNT = 3;
	private static final Integer MAX_BALL_NUM = 9;
	private static final Integer MIN_BALL_NUM = 1;
	private static final Integer ZERO = 0;
	private static Integer CURRENT_BALL_CNT = 0;

	public ComputerBaseballService() {
		Computer computer = Computer.getInstance();
		computer.clearNumbers();
		for (CURRENT_BALL_CNT = ZERO; CURRENT_BALL_CNT < MAX_BALL_CNT; CURRENT_BALL_CNT++) {
			int nextNumber = RandomUtils.nextInt(MIN_BALL_NUM, MAX_BALL_NUM);
			if (computer.getNumbers().contains(nextNumber)) {
				CURRENT_BALL_CNT--;
			} else {
				computer.setNumber(nextNumber);
			}
		}
	}
}
