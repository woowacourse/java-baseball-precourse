/**
 * baseballGame 실행을 위한 Main 클래스
 * 
 * @version 0.1 2019년 11월 28일
 * @author 박두원
 *
 */

import baseballgame.BaseballGame;
public class Main {

	public static void main(String[] args) {
			BaseballGame m = new BaseballGame();
			m.startGame();
			System.out.println("게임을 종료합니다.");
	}

}
