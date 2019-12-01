package com.precourse.bassballapp;

import com.precourse.bassballapp.StrikeBall;

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
