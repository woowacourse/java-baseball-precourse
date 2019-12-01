package com.precourse.bassballapp;

import com.precourse.bassballapp.Cpu;

public class CpuTest {

	public static void main(String[] args) {
		//randomGenereation test
		System.out.println("==randomGeneration test==");
		System.out.println(Cpu.getRandomNum());
		
		//cpuInput test
		System.out.println("==cpuInput test==");
		int[] testArray = Cpu.makeAnswer();
		System.out.println(testArray[0]);
		System.out.println(testArray[1]);
		System.out.println(testArray[2]);
	}

}
