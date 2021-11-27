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
		
		/*while(true) {
			System.out.print("숫자를 입력해주세요 : ");
			String userNum = user.userNumber();
			int strike = countStrike(ranNum, userNum);
		}*/
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
	
	/*
	public void 게임 플레이 playGame () {
		String 출력할 메시지 result = "";
		
		while(true) {
			입력메시지 출력 ("숫자를 입력해주세요: ")
			유저입력수 userNum = next() 메소드로 입력받음
			int b = 볼 개수 카운팅 메소드 countBall 사용
			int s = 스트라이크 카운팅 메소드 countStrike 사용
			result = printResult(b,s)
			result 출력
			if(b == DIGIT) {
				break
			} 
		}
	}
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
	private String 결과출력 printResult (int 볼 개수 b, int 스트라이크 개수 s) {
		//스트라이크 개수와 볼 개수를 불러와서 결과를 출력해줌
		String res = "";
		if(스트라이크 == 0 && 볼 == 0) {
			return "낫싱"
		}
		if(볼 >0) {
			res += Integer.toString(b) + "볼 "
		}
		if(스트라이크 >0) {
			res += Integer.toString(s) + "스트라이크 "
		}
		if(스트라이크 == DIGIT) {
			res += "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"
		}
		res = res.trim() 메소드로 앞뒤 공백 제거
		
		return res
	}
	
	*/

}
