package com.precourse.bassballapp;

import com.precourse.bassballapp.*;

public class BassballApp {
	
	public static void main(String[] args) {
		/*프로그램 구조*/
		Cpu.answerArr = Cpu.makeAnswer();
		while (true) {
			System.out.println("[[디버깅용 메세지]]-컴퓨터 세자리 수 : " 
					+ Cpu.answerArr[0] + ","
					+ Cpu.answerArr[1] + ","
					+ Cpu.answerArr[2]);
			
			User.answerArr = User.getValidAnswer2();
			
			int[] tmp1 = User.answerArr;
			int[] tmp2 = Cpu.answerArr;
			StrikeBall.resultArr = StrikeBall.count(tmp1, tmp2);
			Result.print(StrikeBall.resultArr);
		}
	}
}
