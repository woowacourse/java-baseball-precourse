package baseball;
import java.util.HashSet;

import camp.nextstep.edu.missionutils.*;

public class Baseball {
	private static final int DIGIT = 3;
	private Computer computer;
	private User user;
	
	public Baseball () {
		this.computer = new Computer();
		this.user = new User();
	}
	
	public void playGame() {
		String result = "";
		String ranNum = computer.generateRanNum(DIGIT);
		
		while(true) {
			System.out.print("숫자를 입력해주세요 : ");
			String userNum = user.userNumber();
			int strike = countStrike(ranNum, userNum);
			int ball = countBall(ranNum, userNum);
			result = printResult(ball,strike);
			System.out.println(result);
			if(strike == DIGIT) {
				break;
			}
		}
	}
	public boolean restart() {
		String select = Console.readLine();
		
		if(select == "1") {
			return true;
		}
		if(select == "2") {
			return false;
		}
		throw new IllegalArgumentException();
	}
	
	private int countStrike(String ranNum, String userNum) {
		int s = 0;
		for(int i=0;i<DIGIT;i++) {
			if(ranNum.charAt(i) == userNum.charAt(i)) {
				s++;
			}
		}
		return s;
	}
	
	private int countBall(String ranNum, String userNum) {
		int b = 0;
		for(int i=0;i<DIGIT;i++) {
			int idx = ranNum.indexOf(userNum.charAt(i));
			if(idx > -1 && idx != i) {
				b++;
			}
		}
		return b;
	}
	
	private String printResult(int ball, int strike) {
		String res = "";
		if(ball == 0 && strike == 0) {
			return "낫싱";
		}
		if(ball>0) {
			res += Integer.toString(ball) + "볼 ";
		}
		if(strike>0) {
			res += Integer.toString(strike) + "스트라이크";
		}
		if(strike == DIGIT) {
			res += "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
		}
		return res;
	}
	
	/*
	
	public boolean 재시작할지 Restart () {
		String 재시작 할지 선택 select = 유저에게 입력받음
		if(select가 "1"이라면) {
			return true
		}
		if(select가 "2"라면) {
			return false
		}
		return IllegalArgumentException
	}
	
	*/

}
