/**
 * 클래스 이름       GameRound
 * 버전 정보        1.0
 * 날짜            2019.12.03
 * 저작권          joi0104
 */

public class GameRound {
	Input input;
	Answer answer;
	GameScore score;
	boolean correct;
	
	GameRound(){
		input = new Input();
		answer = new Answer();
		score = new GameScore();
		correct = false;
	}
	
	/*게임 라운드 실행*/
	public void playGame() {
			int[] answerNum = answer.createAnswer();              //정답값 생성
	
		while(!correct){
			int[] inputNum = input.getInput();                    //사용자에게 입력값 받기
			int[] scoreNum = score.getScore(answerNum,inputNum);  //정답값과 입력값을 기준으로 score 받기
			printScore(scoreNum,answerNum);                       //score 프린트하기
		};
	}
	
	/*score 프린트하는 함수*/
	public void printScore(int[] scoreNum,int[] answerNum) {
		if(scoreNum[0]!=0) { System.out.print(scoreNum[0]+" 스트라이크 "); }
		if(scoreNum[1]!=0) { System.out.print(scoreNum[1]+" 볼 "); }
		if(scoreNum[2]!=0) { System.out.print("낫싱"); }
		System.out.println();
	}
	
}
