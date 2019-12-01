package com.precourse.bassballapp;

import com.precourse.bassballapp.User;

public class UserTest {

	public static void main(String[] args) {
		/*
		//userInput test
		System.out.println("==userInput test==");
		int[] result1 = UserInput.userInput();
		System.out.println("결괏값 백의자리 수:" + result1[1]);
		System.out.println("결괏값 십의자리 수:" + result1[2]);
		System.out.println("결괏값 일의자리 수:" + result1[3]);
		*/
		
		/*
		//userInputValid test
		System.out.println("==userInputValid test==");
		int[] result2 = UserInput.userInputValid();
		System.out.println("결괏값 백의자리 수:" + result2[1]);
		System.out.println("결괏값 십의자리 수:" + result2[2]);
		System.out.println("결괏값 일의자리 수:" + result2[3]);
		*/
		
		//userInputValid2 test
		System.out.println("==userInputValid2 test==");
		int[] result3 = User.getValidAnswer2();
		System.out.println("결괏값 :" + result3[0]);

	}

}
