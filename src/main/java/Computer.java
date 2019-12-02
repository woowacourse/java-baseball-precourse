package src.main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 1에서 9까지 서로 다른 임의의 세 수를 저장하는 클래스
 * 
 * @author smr60
 *
 */
public class Computer {

	/** 게임을 위해 필요한 숫자의 자릿 수 */
	private static final int DIGITS = 3;
	
	/** 게임에 사용되는 숫자의 범위 1 ~ 9 를 만들기 위한 상수 */
	private static final int MAX = 9;
	private static final int MIN = 1;

	/** 컴퓨터가 랜덤으로 지정한 숫자를 저장하는 리스트 */
	List<Integer> comNums;

	/**
	 * 컴퓨터가 1에서 9까지의 서로다른 임의의 수를 리스트에 저장하는 메소드 입니다.
	 */
	void createNumbers() {
		comNums = new ArrayList<>();
		while (comNums.size() < DIGITS) {
			int rand = (int) ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
			if (!comNums.contains(rand)) {
				comNums.add(rand);
			}
		}
	}
}
