/**
 * @(#)UserTest.java
 * 0.0.0
 * 2019/12/03
 * 저작권 및 라이센스
 */

package com.precourse.bassballapp;

import com.precourse.bassballapp.User;

/**
 * User 클래스 멤버들의 정상작동여부 테스트
 * @version 0.0.0 2019년 12월 03일
 * @author tiroring
 */
public class UserTest {

	public static void main(String[] args) {
		/*
		//userInput test
		System.out.println("==userInput test==");
		int[] result1 = UserInput.userInput();
		System.out.println("결괏값:" + result1[0]);
		System.out.println("결괏값 백의자리 수:" + result1[1]);
		System.out.println("결괏값 십의자리 수:" + result1[2]);
		System.out.println("결괏값 일의자리 수:" + result1[3]);
		*/
		
		/*
		//userInputValid test
		System.out.println("==userInputValid test==");
		int[] result2 = UserInput.userInputValid();
		System.out.println("결괏값:" + result2[0]);
		System.out.println("결괏값 백의자리 수:" + result2[1]);
		System.out.println("결괏값 십의자리 수:" + result2[2]);
		System.out.println("결괏값 일의자리 수:" + result2[3]);
		*/
		
		//userInputValid2 test
		System.out.println("==userInputValid2 test==");
		int[] result3 = User.getValidAnswer2();
		System.out.println("결괏값 :" + result3[0]);
		System.out.println("결괏값 백의자리 수:" + result3[1]);
		System.out.println("결괏값 십의자리 수:" + result3[2]);
		System.out.println("결괏값 일의자리 수:" + result3[3]);

	}

}
