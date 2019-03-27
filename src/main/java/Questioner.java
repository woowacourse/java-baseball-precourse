/*
 * @(#) Questioner.java     1.0   2019/03/26
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
		this.number = new int[3]; /* 3자리 수 */
	}

	/**
	 * 문제(서로 다른 3자리 수)를 만든다.
	 * @return 문제(서로다른 3자리수 배열)
	 */
	public int[] setNumber() {
		Random rand = new Random();

		for (int i = 0; i < this.number.length; i++) {

			/* 중복되는 숫자가 존재하면 반복해서 랜덤 숫자를 만들어 할당한다. */
			int num;
			do {

				int bound = 9;
				int addNum = 1;
				num = rand.nextInt(bound) + addNum;        /* 1~9사이의 랜덤 숫자 */
			} while ( checkReduplicate(num, this.number, i) );
			this.number[i] = num;        /* 중복되지 않은 숫자를 자리에 넣는다. */
		}
		return this.number;
	}

	/**
	 * 숫자가 이전 숫자들과 중복됬는지 확인한다.
	 * @param num 확인할 숫자
	 * @param number 수 배열
	 * @param index 배열 위치 index 전 까지 중복 검사
	 * @return 중복됬으면 true, 아니라면 false
	 */
	private boolean checkReduplicate(int num, int[] number, int index) {
		for (int i = 0; i < index; i++) {

			/* 삽입할 index 위치 전에서 중복이 발생한다. */
			if (num == number[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 만들어진 문제(서로다른 3자리 수 배열)를 반환한다.
	 * @return 문제(서로다른 3자리 수 배열)
	 */
	public int[] getNumber() {
		return this.number;
	}
}