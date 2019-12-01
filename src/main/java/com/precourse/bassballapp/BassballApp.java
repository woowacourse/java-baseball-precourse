package com.precourse.bassballapp;

import com.precourse.bassballapp.Cpu;
import com.precourse.bassballapp.User;
import com.precourse.bassballapp.Result;
import com.precourse.bassballapp.StrikeBall;

public class BassballApp {
	
	public static void main(String[] args) {
		/*프로그램 구조*/
		boolean isLoopActive = true;
		Cpu.answerArr = Cpu.makeAnswer();
		while (isLoopActive) {
			System.out.println("[[디버깅용 메세지]]-컴퓨터 세자리 수 : " 
					+ Cpu.answerArr[0]+","
					+ Cpu.answerArr[1]+","
					+ Cpu.answerArr[2]);
			User.answerArr = User.getValidAnswer2();
			StrikeBall.resultArr = StrikeBall.count(User.answerArr, Cpu.answerArr);
			Result.print(StrikeBall.resultArr);
		}
	}
}
