/**
 * @(#)StrikeBallTest.java
 * 0.0.0
 * 2019/12/03
 * 저작권 및 라이센스
 */

package com.precourse.bassballapp;

import com.precourse.bassballapp.StrikeBall;

/**
 * StrikeBall 클래스 멤버들의 정상작동여부 테스트
 * @version 0.0.0 2019년 12월 3일
 * @author tiroring
 */
public class StrikeBallTest {

	public static void main(String[] args) {
		//SBCount test
		System.out.println("==SBCount test==");
		int[] user1 = {123,1,2,3};
		int[] cpu1 = {1,2,3};
		int[] result1 = StrikeBall.count(user1, cpu1);
		System.out.println(result1[0]);
		System.out.println(result1[1]);
	}

}
