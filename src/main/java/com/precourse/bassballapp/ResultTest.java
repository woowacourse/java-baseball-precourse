/**
 * @(#)ResultTest.java
 * 0.0.0
 * 2019/12/03
 * 저작권 및 라이센스
 */

package com.precourse.bassballapp;

import com.precourse.bassballapp.Result;

/**
 * Result 클래스 멤버들의 정상작동여부 테스트
 * @version 0.0.0 2019년 12월 3일
 * @author tiroring
 */
public class ResultTest {

	public static void main(String[] args) {
		
		// printOut test
		System.out.println("==printOut test==");
		int[] test1 = {0,0};
		int[] test2 = {0,1};
		int[] test3 = {0,2};
		int[] test4 = {0,3};
		int[] test5 = {1,0};
		int[] test6 = {2,0};
		int[] test7 = {1,1};
		int[] test8 = {1,2};
		int[] test9 = {3,0};
		Result.print(test1);
		Result.print(test2);
		Result.print(test3);
		Result.print(test4);
		Result.print(test5);
		Result.print(test6);
		Result.print(test7);
		Result.print(test8);
		Result.print(test9);
		
		//newGameQuery test
		System.out.println("==newGameQuery test==");
		Result.newGameQuery();
	}

}
