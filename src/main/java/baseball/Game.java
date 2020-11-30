package baseball;

public class Game {

	Player player = new Player();
	Hint hint = new Hint();
	Answer answer = new Answer();

	// 실제 게임을 실행하는 함수
	public void startGame() {
		// 타깃 넘버 생성 
		answer.makeAnswer();

		// 게임 한 세트 실행
    	while(!hint.flag) {
    		player.getPlayerNum();
    		hint.makeHint(answer.answerNum, player.playerNum);
    		hint.clearStrikeAndBall();
    	}
    	
    	// 다음 게임을 위한 초기화 실행
    	hint.flag = false;
    	hint.clearStrikeAndBall();
	}
}
