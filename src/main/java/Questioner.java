/*
 * @(#) Questioner.java     1.0   20191/03/26
 *
 * Released under the MIT license
 */

import java.util.Random;

/**
 * Questioner 클래스는 숫자야구게임의 문제(서로 다른 3자리 수)를 만들고 소유한다.
 *
 * @version  1.00  2019년 03월 26일
 * @author   조남균
 */
public class Questioner {

	/** 문제(서로 다른 3자리수)의 배열 */
	private int[] number;

	/**
	 * 문제의 자리수를 3자리로 초기화한다.
	 */
	public Questioner() {
		this.number = new int[3]; // 3자리 수
	}

	/**
	 * 문제(서로 다른 3자리 수)를 만든다.
	 * @return 문제(서로다른 3자리수 배열)
	 * */
	public int[] setNumber() {

		Random rand = new Random(); // 랜덤숫자를 반환을 위한 rand 객체
		for(int i = 0; i < this.number.length; i++) {

			int num;

			do {

				int bound = 9;
				int addNum = 1;
				num = rand.nextInt(bound) + addNum; /* 1~9사이의 랜덤 숫자 */

				/* 중복되는 숫자가 존재하는지 확인한다. */
			} while ( checkReduplicate(num, this.number, i) );

			this.number[i] = num; /* 중복되지 않은 숫자를 자리에 넣는다. */
		}
		return this.number;
	}

	/**
	 * 숫자가 이전 숫자들과 중복됬는지 확인한다.
	 * @param num 확인할 숫자
	 * @param number 수 배열
	 * @param index 배열 위치 index 전 까지 중복 검사
	 * @return 중복됬으면 true, 아니라면 false
	 * */
	private boolean checkReduplicate(int num, int[] number, int index) {

		boolean isReduplicate = false;

		for(int i = 0; i < index; i++) {

			/* index 위치 이전 까지 중복 확인 */
			if(num == number[i]) {

				/* 중복될 경우 */
				isReduplicate = true;
				break;
			}
		}

		return isReduplicate;
	}
}