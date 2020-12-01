package service;

import domain.Computer;
import utils.RandomUtils;

/**
 * 숫자야구의 컴퓨터(상대방)턴
 * 기능 1. 중복되지 않도록 임의의 숫자를 생성해 숫자 리스트에 저장
 */
public class ComputerBaseballService {
	/** 최대로 생성할 수 있는 숫자 갯수를 한정하는 상수 */
	private static final Integer MAX_BALL_CNT = 3;
	
	/** 임의로 뽑는 숫자 범위를 한정하는 상수 */
	private static final Integer MAX_BALL_NUM = 9;
	private static final Integer MIN_BALL_NUM = 1;
	
	/** 초기값을 위한 상수 */
	private static final Integer ZERO = 0;
	
	/** 현재 생성된 숫자를 카운팅하는 변수 */
	private static Integer CURRENT_BALL_CNT = 0;

	public ComputerBaseballService() {
		initNumbers();
	}

	public void initNumbers() {
		/** 객체 불러오기 */
		Computer computer = Computer.getInstance();

		/** 객체의 숫자 리스트 비우기 */
		computer.clearNumbers();
		
		for (CURRENT_BALL_CNT = ZERO; CURRENT_BALL_CNT < MAX_BALL_CNT; CURRENT_BALL_CNT++) {
			/** 범위에 해당하는 임의의 숫자 뽑기 */
			int nextNumber = RandomUtils.nextInt(MIN_BALL_NUM, MAX_BALL_NUM);
			
			/** 중복된 숫자인지 확인 */
			if (computer.getNumbers().contains(nextNumber)) {
				CURRENT_BALL_CNT--; // 중복일 경우 한번 더 진행
			} else {
				computer.addNumber(nextNumber); // 중복이 아닐 경우 숫자 리스트에 넣음
			}
		}
	}
}
