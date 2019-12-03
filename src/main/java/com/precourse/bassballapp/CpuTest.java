/**
 * @(#)CpuTest.java
 * 0.0.0
 * 2019/12/03
 * 저작권 및 라이센스
 */

package com.precourse.bassballapp;

import com.precourse.bassballapp.Cpu;

/**
 * Cpu 클래스 멤버들의 정상작동여부 테스트
 * @version 0.0.0 2019년 12월 3일
 * @author tiroring
 */
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
