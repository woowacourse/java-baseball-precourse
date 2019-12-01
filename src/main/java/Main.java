package main.java;

public class Main {
	public static void main (String[] args) {
		Computer computer = new Computer();
		User user = new User();
		Matching matching = new Matching();
		Result result = new Result();
		
		int[] target = computer.make_list();			// 랜덤 넘버(3개)를 array로 가져옴
		int[] success = new int[2];			// [성공여부, 재시작여부]
		
		while (true) {
			int[] answer = user.input();			// 사용자가 답한 숫자
			
			int strike = matching.strike(target, answer);			// 스트라이크 갯수
			int ball = matching.ball(target, answer);			// 볼 갯수
			
			success = result.release(strike, ball);			// 결과 응답
			
			if (success[0] == 1) {
				break;			// 성공여부가 1일때 답을 맞춘 것이며, while 빠져나옴
			}
		}
		
		if (success[1] == 1) {
			main(args);			// 재시작여부가 1일때 재시작을 의미하며, main으로 돌아가서 게임을 재시작함
		}
	}
	
}
