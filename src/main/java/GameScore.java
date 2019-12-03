/**
 * 클래스 이름       GameScore
 * 버전 정보        1.0
 * 날짜            2019.12.03
 * 저작권          joi0104
 */

public class GameScore {
	int[] score;
	int[] answer;
	int[] input;
	
	GameScore() {
		score = new int[3];
		answer = new int[3];
		input = new int[3];
	}
	
	/*스크라이크 수를 세는 함수*/
	public void checkStrike() {
		score[0]=0;                               //스크라이크 수 초기화
		if(answer[0]==input[0]) score[0]++;
		if(answer[1]==input[1]) score[0]++;
		if(answer[2]==input[2]) score[0]++;
	}
	
	/*볼 수를 세는 함수*/
	public void checkBool() {
		score[1]=0;                               //볼 수 초기화
		if(input[0]==answer[1]) score[1]++;
		if(input[0]==answer[2]) score[1]++;
		if(input[1]==answer[0]) score[1]++;
		if(input[1]==answer[2]) score[1]++;
		if(input[2]==answer[0]) score[1]++;
		if(input[2]==answer[1]) score[1]++;
		
	}
	
	/*낫싱인지 아닌지 확인하는 함수*/
	public void checkNothing() {
		score[2]=0;                               //낫싱 초기화
		if(score[0]==0 && score[1]==0) score[2]=1;
	}

	/*스트라이크,볼,낫싱값이 들어간 score를 함수*/
	public int[] getScore(int[] answer, int[] input) {
		this.answer = answer;
		this.input = input;
		checkStrike();                           //스크라이크 확인
		checkBool();                             //볼 확인
		checkNothing();                          //낫싱 확인
		return score;
	}
	
}
